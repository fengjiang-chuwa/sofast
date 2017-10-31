package com.sofast.application.dao;

import com.sofast.application.model.StudentBasic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface StudentBasicDao extends CrudRepository<StudentBasic, String> {
    StudentBasic findById(String id);
    StudentBasic findByEmail(String email);

    StudentBasic findByApplicantEmailAddress(String applicantEmailAddress);
}