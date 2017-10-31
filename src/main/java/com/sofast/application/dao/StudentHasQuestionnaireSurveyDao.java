package com.sofast.application.dao;

import com.sofast.application.model.StudentHasQuestionnaireSurvey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentHasQuestionnaireSurveyDao extends CrudRepository<StudentHasQuestionnaireSurvey, String> {
    List<StudentHasQuestionnaireSurvey> findAllByStudentId(String studentId);
}