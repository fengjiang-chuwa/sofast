package com.sofast.application.dao;

import com.sofast.application.model.StudentHasStandardizedTestAccountInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentHasStandardizedTestAccountInfoDao extends CrudRepository<StudentHasStandardizedTestAccountInfo, String> {
    List<StudentHasStandardizedTestAccountInfo> findAllByStudentId(String studentId);
}