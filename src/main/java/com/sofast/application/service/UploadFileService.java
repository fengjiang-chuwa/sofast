package com.sofast.application.service;

import com.sofast.application.model.UploadFile;

public interface UploadFileService extends BaseService<UploadFile, String> {

    UploadFile findById(String id);
}