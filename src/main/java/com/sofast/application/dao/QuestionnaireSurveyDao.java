package com.sofast.application.dao;

import com.sofast.application.model.QuestionnaireSurvey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface QuestionnaireSurveyDao extends CrudRepository<QuestionnaireSurvey, String> {
    List<QuestionnaireSurvey> findAllById(List<String> ids);
}