package com.sofast.application.dao;

import com.sofast.application.model.StudentHasUploadFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentHasUploadFileDao extends CrudRepository<StudentHasUploadFile, String> {
    List<StudentHasUploadFile> findAllByStudentId(String studentId);
}