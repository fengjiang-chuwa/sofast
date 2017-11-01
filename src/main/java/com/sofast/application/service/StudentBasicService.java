package com.sofast.application.service;

import com.sofast.application.model.*;

import java.util.List;

public interface StudentBasicService extends BaseService<StudentBasic, String> {
    StudentBasic findById(String id);

    StudentBasic findByLinkId(String linkId);

    StudentBasic findByEmail(String email);

    StudentInfo findStudentInfoByStudentBasicId(String studentBasicId);

    List<Country> findAllCountryList();

    List<QuestionnaireSurvey> findAllQuestionnaireSurveyList();

    List<Address> findAddressList(List<String> ids);

    List<EducationInfo> findEducationInfoList(List<String> ids);

    List<QuestionnaireSurvey> findQuestionnaireSurveyList(List<String> ids);

    List<RecommenderInfo> findRecommenderInfoList(List<String> ids);

    List<Relationship> findRelationshipList(List<String> ids);

    List<StandardizedTestAccountInfo> findStandardizedTestAccountInfoList(List<String> ids);

    List<StudentHasAddress> findStudentHasAddressList(String studentId);

    List<StudentHasEducationInfo> findStudentHasEducationInfoList(String studentId);

    List<StudentHasQuestionnaireSurvey> findStudentHasQuestionnaireSurveyList(String studentId);

    List<StudentHasRecommenderInfo> findStudentHasRecommenderInfoList(String studentId);

    List<StudentHasRelationship> findStudentHasRelationshipList(String studentId);

    List<StudentHasStandardizedTestAccountInfo> findStudentHasStandardizedTestAccountInfoList(String studentId);
}