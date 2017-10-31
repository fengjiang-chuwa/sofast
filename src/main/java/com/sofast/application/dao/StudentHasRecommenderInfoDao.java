package com.sofast.application.dao;

import com.sofast.application.model.StudentHasRecommenderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentHasRecommenderInfoDao extends CrudRepository<StudentHasRecommenderInfo, String> {
    List<StudentHasRecommenderInfo> findAllByStudentId(String studentId);
}