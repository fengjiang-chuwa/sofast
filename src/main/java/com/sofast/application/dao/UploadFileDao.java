package com.sofast.application.dao;

import com.sofast.application.model.UploadFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UploadFileDao extends CrudRepository<UploadFile, String> {
    UploadFile findById(String id);
}