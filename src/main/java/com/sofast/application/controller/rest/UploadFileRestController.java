package com.sofast.application.controller.rest;

import com.google.common.base.Strings;
import com.sofast.application.entity.JsonResponse;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.CommUploadFile;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.service.CommUploadFileService;
import com.sofast.application.service.StudentBasicService;
import com.sofast.application.util.FileTypeCheck;
import com.sofast.application.util.UUIDHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

@Slf4j
@RestController
public class UploadFileRestController {

    @Value("${upload.path}")
    private String uploadPath;

    private final CommUploadFileService commUploadFileService;

    private final StudentBasicService studentBasicService;

    @Autowired
    public UploadFileRestController(CommUploadFileService commUploadFileService, StudentBasicService studentBasicService) {
        this.commUploadFileService = commUploadFileService;
        this.studentBasicService = studentBasicService;
    }


    @RequestMapping(value = "/fileUpload/{linkId}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<CommUploadFile> fileUpload(HttpServletRequest request, @PathVariable String linkId) {
        MultipartHttpServletRequest mRequest;
        try {
            StudentBasic studentBasic = studentBasicService.findByLinkId(linkId);
            if (studentBasic == null) {
                throw new MsgException("invalid link id");
            }
            CommUploadFile commUploadFile = null;
            mRequest = (MultipartHttpServletRequest) request;
            mRequest.getParameterMap();
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile mFile = mRequest.getFile(itr.next());
                boolean check = FileTypeCheck.checkUploadFilePdfType(mFile);
                if (!check) {
                    return new JsonResponse<>(null);
                }
                String fileName = mFile.getOriginalFilename();
                String fileRealName = fileName.replace(".pdf", "-" + UUIDHelper.getUUID() + ".pdf");
                mFile.transferTo(new File(uploadPath + fileRealName));
                commUploadFile = createUploadFile(mRequest.getParameter("description"), fileName, fileRealName,
                        mRequest.getParameter("uploadStatus"), studentBasic.getId());
                commUploadFileService.save(commUploadFile);
                return new JsonResponse<>(commUploadFile);
            }
        } catch (Exception e) {
            log.error("fileUpload", e);
        }
        return new JsonResponse<>(null);
    }

    private CommUploadFile createUploadFile(String description, String fileName, String fileRealName, String status,
                                            String uploadBy) {
        CommUploadFile commUploadFile = new CommUploadFile();
        commUploadFile.setId(UUIDHelper.getUUID());
        commUploadFile.setDescription(description);
        commUploadFile.setFileDispName(fileName);
        commUploadFile.setFileRealName(fileRealName);
        commUploadFile.setFilePath(uploadPath);
        commUploadFile.setUploadBy(uploadBy);
        commUploadFile.setUploadDate(new Date());
        commUploadFile.setStatus(status);
        return commUploadFile;
    }

    @RequestMapping(value = "/fileUpload/remove/{linkId}/{uploadFileId}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<String> removeFileUpload(@PathVariable String linkId, @PathVariable String uploadFileId) {
        try {
            if(!Strings.isNullOrEmpty(uploadFileId)) {
                StudentBasic studentBasic = studentBasicService.findByLinkId(linkId);
                if (studentBasic == null) {
                    throw new MsgException("invalid link id");
                }
                CommUploadFile commUploadFile = commUploadFileService.findById(uploadFileId);
                if (commUploadFile == null) {
                    throw new MsgException("invalid uploaded file id");
                }
                if(!studentBasic.getId().equalsIgnoreCase(commUploadFile.getUploadBy())){
                    throw new MsgException("invalid link id");
                }
                commUploadFileService.delete(uploadFileId);
            }
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("removeFileUpload", e);
            return new JsonResponse<>("error");
        }
    }
}
