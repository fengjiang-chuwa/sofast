package com.sofast.application.dao;

import com.sofast.application.model.StudentInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface StudentInfoDao extends CrudRepository<StudentInfo, String> {
    StudentInfo findById(String id);
    StudentInfo findByStudentBasicId(String studentBasicId);
}