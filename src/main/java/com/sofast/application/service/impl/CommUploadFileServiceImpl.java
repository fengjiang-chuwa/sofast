package com.sofast.application.service.impl;

import com.sofast.application.dao.CommUploadFileDao;
import com.sofast.application.model.CommUploadFile;
import com.sofast.application.service.CommUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommUploadFileServiceImpl extends BaseServiceImpl<CommUploadFile, String> implements CommUploadFileService {

    private final CommUploadFileDao commUploadFileDao;


    @Autowired
    public CommUploadFileServiceImpl(CommUploadFileDao commUploadFileDao) {
        this.commUploadFileDao = commUploadFileDao;
        this.crudRepository = commUploadFileDao;
    }

    @Override
    public CommUploadFile findById(String id) {
        return commUploadFileDao.findById(id);
    }
}
