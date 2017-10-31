package com.sofast.application.dao;

import com.sofast.application.model.StudentHasEducationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentHasEducationInfoDao extends CrudRepository<StudentHasEducationInfo, String> {
    List<StudentHasEducationInfo> findAllByStudentId(String studentId);
}