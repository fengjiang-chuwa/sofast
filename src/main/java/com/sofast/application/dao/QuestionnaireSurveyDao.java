package com.sofast.application.dao;

import com.sofast.application.model.QuestionnaireSurvey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface QuestionnaireSurveyDao extends CrudRepository<QuestionnaireSurvey, String>, PagingAndSortingRepository<QuestionnaireSurvey, String> {
}