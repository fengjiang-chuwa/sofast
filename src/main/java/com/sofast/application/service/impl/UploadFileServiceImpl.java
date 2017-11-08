package com.sofast.application.service.impl;

import com.sofast.application.dao.UploadFileDao;
import com.sofast.application.model.UploadFile;
import com.sofast.application.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UploadFileServiceImpl extends BaseServiceImpl<UploadFile, String> implements UploadFileService {

    private final UploadFileDao uploadFileDao;


    @Autowired
    public UploadFileServiceImpl(UploadFileDao uploadFileDao) {
        this.uploadFileDao = uploadFileDao;
        this.crudRepository = uploadFileDao;
    }

    @Override
    public UploadFile findById(String id) {
        return uploadFileDao.findById(id);
    }
}