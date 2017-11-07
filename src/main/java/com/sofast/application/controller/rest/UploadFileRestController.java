package com.sofast.application.controller.rest;

import com.google.common.base.Strings;
import com.sofast.application.entity.JsonResponse;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.UploadFile;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.service.UploadFileService;
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

    private final UploadFileService uploadFileService;

    private final StudentBasicService studentBasicService;

    @Autowired
    public UploadFileRestController(UploadFileService uploadFileService, StudentBasicService studentBasicService) {
        this.uploadFileService = uploadFileService;
        this.studentBasicService = studentBasicService;
    }


    @RequestMapping(value = "/fileUpload/{linkId}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<UploadFile> fileUpload(HttpServletRequest request, @PathVariable String linkId) {
        MultipartHttpServletRequest mRequest;
        try {
            StudentBasic studentBasic = studentBasicService.findByLinkId(linkId);
            if (studentBasic == null) {
                throw new MsgException("invalid link id");
            }
            UploadFile uploadFile = null;
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
                uploadFile = createUploadFile(mRequest.getParameter("description"), fileName, fileRealName,
                        mRequest.getParameter("uploadStatus"), studentBasic.getId());
                uploadFileService.save(uploadFile);
                return new JsonResponse<>(uploadFile);
            }
        } catch (Exception e) {
            log.error("fileUpload", e);
        }
        return new JsonResponse<>(null);
    }

    private UploadFile createUploadFile(String description, String fileName, String fileRealName, String status,
                                            String uploadBy) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setId(UUIDHelper.getUUID());
        uploadFile.setDescription(description);
        uploadFile.setFileDispName(fileName);
        uploadFile.setFileRealName(fileRealName);
        uploadFile.setFilePath(uploadPath);
        uploadFile.setUploadBy(uploadBy);
        uploadFile.setUploadDate(new Date());
        uploadFile.setStatus(status);
        return uploadFile;
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
                UploadFile uploadFile = uploadFileService.findById(uploadFileId);
                if (uploadFile == null) {
                    throw new MsgException("invalid uploaded file id");
                }
                if(!studentBasic.getId().equalsIgnoreCase(uploadFile.getUploadBy())){
                    throw new MsgException("invalid link id");
                }
                uploadFileService.delete(uploadFileId);
            }
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("removeFileUpload", e);
            return new JsonResponse<>("error");
        }
    }
}