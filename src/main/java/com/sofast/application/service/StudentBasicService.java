package com.sofast.application.service;

import com.sofast.application.model.*;

import java.util.List;

public interface StudentBasicService extends BaseService<StudentBasic, String> {
    StudentBasic findById(String id);

    Address findAddressById(String addressId);

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

    StudentInfo saveStudentInfo(StudentInfo studentInfo);

    Address saveAddress(Address address);
    EducationInfo saveEducationInfo(EducationInfo educationInfo);
    Relationship saveRelationship(Relationship relationship);
    StandardizedTestAccountInfo saveStandardizedTestAccountInfo(StandardizedTestAccountInfo standardizedTestAccountInfo);
    RecommenderInfo saveRecommenderInfo(RecommenderInfo recommenderInfo);
    QuestionnaireSurvey saveQuestionnaireSurvey(QuestionnaireSurvey questionnaireSurvey);

    StudentHasAddress saveStudentHasAddress(StudentHasAddress studentHasAddress);
    StudentHasEducationInfo saveStudentHasEducationInfo(StudentHasEducationInfo studentHasEducationInfo);
    StudentHasRelationship saveStudentHasRelationship(StudentHasRelationship studentHasRelationship);
    StudentHasStandardizedTestAccountInfo saveStudentHasStandardizedTestAccountInfo(StudentHasStandardizedTestAccountInfo studentHasStandardizedTestAccountInfo);
    StudentHasRecommenderInfo saveStudentHasRecommenderInfo(StudentHasRecommenderInfo studentHasRecommenderInfo);
    StudentHasQuestionnaireSurvey saveStudentHasQuestionnaireSurvey(StudentHasQuestionnaireSurvey studentHasQuestionnaireSurvey);

    void deleteAddress(Address address);
    void deleteEducationInfo(EducationInfo educationInfo);
    void deleteRelationship(Relationship relationship);
    void deleteStandardizedTestAccountInfo(StandardizedTestAccountInfo standardizedTestAccountInfo);
    void deleteRecommenderInfo(RecommenderInfo recommenderInfo);
    void deleteQuestionnaireSurvey(QuestionnaireSurvey questionnaireSurvey);

    void deleteStudentHasAddress(StudentHasAddress studentHasAddress);
    void deleteStudentHasEducationInfo(StudentHasEducationInfo studentHasEducationInfo);
    void deleteStudentHasRelationship(StudentHasRelationship studentHasRelationship);
    void deleteStudentHasStandardizedTestAccountInfo(StudentHasStandardizedTestAccountInfo studentHasStandardizedTestAccountInfo);
    void deleteStudentHasRecommenderInfo(StudentHasRecommenderInfo studentHasRecommenderInfo);
    void deleteStudentHasQuestionnaireSurvey(StudentHasQuestionnaireSurvey studentHasQuestionnaireSurvey);
}