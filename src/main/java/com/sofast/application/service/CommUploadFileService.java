package com.sofast.application.service;

import com.sofast.application.model.CommUploadFile;

public interface CommUploadFileService extends BaseService<CommUploadFile, String> {

    CommUploadFile findById(String id);
}
