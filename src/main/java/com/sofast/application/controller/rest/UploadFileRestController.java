package com.sofast.application.controller.rest;

import com.google.common.base.Strings;
import com.sofast.application.entity.JsonResponse;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.model.StudentHasUploadFile;
import com.sofast.application.model.UploadFile;
import com.sofast.application.service.StudentBasicService;
import com.sofast.application.service.UploadFileService;
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


    @RequestMapping(value = "/fileUpload/{id}/{type}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<UploadFile> fileUpload(HttpServletRequest request, @PathVariable String id,
                                               @PathVariable String type) {
        MultipartHttpServletRequest mRequest;
        UploadFile uploadFile;
        try {
            StudentBasic studentBasic;
            if ("studentBasicId".equalsIgnoreCase(type)) {
                studentBasic = studentBasicService.findById(id);
            } else {
                studentBasic = studentBasicService.findByLinkId(id);
            }
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
                uploadFile = createUploadFile(null, fileName, fileRealName, mRequest.getParameter("uploadFileType"), studentBasic.getId());
                studentBasicService.saveUploadFile(uploadFile);
                StudentHasUploadFile studentHasUploadFile = new StudentHasUploadFile();
                studentHasUploadFile.setUploadFileId(uploadFile.getId());
                studentHasUploadFile.setStudentId(studentBasic.getId());
                studentBasicService.saveStudentHasUploadFile(studentHasUploadFile);
                return new JsonResponse<>(uploadFile);
            }
        } catch (Exception e) {
            log.error("fileUpload", e);
        }
        return new JsonResponse<>(null);
    }

    private UploadFile createUploadFile(String description, String fileName, String fileRealName, String type,
                                            String uploadBy) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setId(UUIDHelper.getUUID());
        uploadFile.setDescription(description);
        uploadFile.setFileDispName(fileName);
        uploadFile.setFileRealName(fileRealName);
        uploadFile.setFilePath(uploadPath);
        uploadFile.setUploadBy(uploadBy);
        uploadFile.setUploadDate(new Date());
        uploadFile.setType(type);
        return uploadFile;
    }

    @RequestMapping(value = "/fileUpload/remove/{id}/{type}/{uploadFileId}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<String> removeFileUpload(@PathVariable String id, @PathVariable String type,
                                                 @PathVariable String uploadFileId) {
        try {
            if(!Strings.isNullOrEmpty(uploadFileId)) {
                UploadFile uploadFile = uploadFileService.findById(uploadFileId);
                if (uploadFile == null) {
                    throw new MsgException("Invalid uploaded file id");
                }
                StudentBasic studentBasic;
                if ("studentBasicId".equalsIgnoreCase(type)) {
                    studentBasic = studentBasicService.findById(id);
                } else {
                    studentBasic = studentBasicService.findByLinkId(id);
                }
                StudentHasUploadFile studentHasUploadFile = new StudentHasUploadFile();
                studentHasUploadFile.setStudentId(studentBasic.getId());
                studentHasUploadFile.setUploadFileId(uploadFileId);
                studentBasicService.deleteStudentHasUploadFile(studentHasUploadFile);
                String path = uploadFile.getFilePath() + uploadFile.getFileRealName();
                deleteFile(path);
                uploadFileService.delete(uploadFileId);
            }
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("removeFileUpload", e);
            return new JsonResponse<>("error");
        }
    }

    protected boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}