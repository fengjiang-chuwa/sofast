package com.sofast.application.service.impl;

import com.google.common.collect.Lists;
import com.sofast.application.dao.*;
import com.sofast.application.model.*;
import com.sofast.application.service.StudentBasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentBasicServiceImpl extends BaseServiceImpl<StudentBasic, String> implements StudentBasicService {

    private final StudentBasicDao studentBasicDao;
    private final CountryDao countryDao;
    private final StudentInfoDao studentInfoDao;
    private final AddressDao addressDao;
    private final StudentHasAddressDao studentHasAddressDao;
    private final EducationInfoDao educationInfoDao;
    private final StudentHasEducationInfoDao studentHasEducationInfoDao;
    private final QuestionnaireSurveyDao questionnaireSurveyDao;
    private final StudentHasQuestionnaireSurveyDao studentHasQuestionnaireSurveyDao;
    private final RecommenderInfoDao recommenderInfoDao;
    private final StudentHasRecommenderInfoDao studentHasRecommenderInfoDao;
    private final RelationshipDao relationshipDao;
    private final StudentHasRelationshipDao studentHasRelationshipDao;
    private final StandardizedTestAccountInfoDao standardizedTestAccountInfoDao;
    private final StudentHasStandardizedTestAccountInfoDao studentHasStandardizedTestAccountInfoDao;

    @Autowired
    public StudentBasicServiceImpl(StudentBasicDao studentBasicDao, CountryDao countryDao,
                                   AddressDao addressDao, StudentInfoDao studentInfoDao,
                                   EducationInfoDao educationInfoDao, QuestionnaireSurveyDao questionnaireSurveyDao,
                                   RecommenderInfoDao recommenderInfoDao, RelationshipDao relationshipDao,
                                   StandardizedTestAccountInfoDao standardizedTestAccountInfoDao,
                                   StudentHasAddressDao studentHasAddressDao, StudentHasEducationInfoDao studentHasEducationInfoDao,
                                   StudentHasQuestionnaireSurveyDao studentHasQuestionnaireSurveyDao,
                                   StudentHasRecommenderInfoDao studentHasRecommenderInfoDao,
                                   StudentHasRelationshipDao studentHasRelationshipDao,
                                   StudentHasStandardizedTestAccountInfoDao studentHasStandardizedTestAccountInfoDao) {
        this.studentBasicDao = studentBasicDao;
        this.crudRepository = studentBasicDao;
        this.countryDao = countryDao;
        this.addressDao = addressDao;
        this.studentInfoDao = studentInfoDao;
        this.educationInfoDao = educationInfoDao;
        this.questionnaireSurveyDao = questionnaireSurveyDao;
        this.recommenderInfoDao = recommenderInfoDao;
        this.relationshipDao = relationshipDao;
        this.standardizedTestAccountInfoDao = standardizedTestAccountInfoDao;
        this.studentHasAddressDao = studentHasAddressDao;
        this.studentHasEducationInfoDao = studentHasEducationInfoDao;
        this.studentHasQuestionnaireSurveyDao = studentHasQuestionnaireSurveyDao;
        this.studentHasRecommenderInfoDao = studentHasRecommenderInfoDao;
        this.studentHasRelationshipDao = studentHasRelationshipDao;
        this.studentHasStandardizedTestAccountInfoDao = studentHasStandardizedTestAccountInfoDao;
    }

    @Override
    public StudentBasic findById(String id) {
        return studentBasicDao.findById(id);
    }

    @Override
    public Address findAddressById(String addressId) {
        return addressDao.findById(addressId);
    }

    @Override
    public StudentBasic findByLinkId(String linkId) {
        return studentBasicDao.findByLinkId(linkId);
    }

    @Override
    public StudentBasic findByEmail(String email) {
        return studentBasicDao.findByApplicantEmailAddress(email);
    }

    @Override
    public StudentInfo findStudentInfoByStudentBasicId(String studentBasicId) {
        return studentInfoDao.findByStudentBasicId(studentBasicId);
    }

    @Override
    public List<Country> findAllCountryList(){
        QCountry country = QCountry.country;
        Sort sort = new Sort(Sort.Direction.ASC, "name");
        Iterable<Country> countryList = countryDao.findAll(country.telCode.isNotNull(), sort);
        return Lists.newArrayList(countryList);
    }

    @Override
    public List<QuestionnaireSurvey> findAllQuestionnaireSurveyList(){
        QQuestionnaireSurvey questionnaireSurvey = QQuestionnaireSurvey.questionnaireSurvey;
        Sort sort = new Sort(Sort.Direction.ASC, "sequence");
        Iterable<QuestionnaireSurvey> questionnaireSurveyList = questionnaireSurveyDao.findAll(sort);
        return Lists.newArrayList(questionnaireSurveyList);
    }

    @Override
    public List<Address> findAddressList(List<String> ids){
        Iterable<String> iterable = ids;
        return Lists.newArrayList(addressDao.findAll(iterable));
    }

    @Override
    public List<StudentHasAddress> findStudentHasAddressList(String studentId){
        return studentHasAddressDao.findAllByStudentId(studentId);
    }

    @Override
    public List<EducationInfo> findEducationInfoList(List<String> ids){
        Iterable<String> iterable = ids;
        return Lists.newArrayList(educationInfoDao.findAll(iterable));
    }

    @Override
    public List<StudentHasEducationInfo> findStudentHasEducationInfoList(String studentId){
        return studentHasEducationInfoDao.findAllByStudentId(studentId);
    }

    @Override
    public List<QuestionnaireSurvey> findQuestionnaireSurveyList(List<String> ids){
        Iterable<String> iterable = ids;
        return Lists.newArrayList(questionnaireSurveyDao.findAll(iterable));
    }

    @Override
    public List<StudentHasQuestionnaireSurvey> findStudentHasQuestionnaireSurveyList(String studentId){
        return studentHasQuestionnaireSurveyDao.findAllByStudentId(studentId);
    }

    @Override
    public List<RecommenderInfo> findRecommenderInfoList(List<String> ids){
        Iterable<String> iterable = ids;
        return Lists.newArrayList(recommenderInfoDao.findAll(iterable));
    }

    @Override
    public List<StudentHasRecommenderInfo> findStudentHasRecommenderInfoList(String studentId){
        return studentHasRecommenderInfoDao.findAllByStudentId(studentId);
    }

    @Override
    public List<Relationship> findRelationshipList(List<String> ids){
        Iterable<String> iterable = ids;
        return Lists.newArrayList(relationshipDao.findAll(iterable));
    }

    @Override
    public List<StudentHasRelationship> findStudentHasRelationshipList(String studentId){
        return studentHasRelationshipDao.findAllByStudentId(studentId);
    }

    @Override
    public List<StandardizedTestAccountInfo> findStandardizedTestAccountInfoList(List<String> ids){
        Iterable<String> iterable = ids;
        return Lists.newArrayList(standardizedTestAccountInfoDao.findAll(iterable));
    }

    @Override
    public List<StudentHasStandardizedTestAccountInfo> findStudentHasStandardizedTestAccountInfoList(String studentId){
        return studentHasStandardizedTestAccountInfoDao.findAllByStudentId(studentId);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressDao.save(address);
    }

    @Override
    public EducationInfo saveEducationInfo(EducationInfo educationInfo) {
        return educationInfoDao.save(educationInfo);
    }

    @Override
    public Relationship saveRelationship(Relationship relationship) {
        return relationshipDao.save(relationship);
    }

    @Override
    public StandardizedTestAccountInfo saveStandardizedTestAccountInfo(StandardizedTestAccountInfo standardizedTestAccountInfo) {
        return standardizedTestAccountInfoDao.save(standardizedTestAccountInfo);
    }

    @Override
    public RecommenderInfo saveRecommenderInfo(RecommenderInfo recommenderInfo) {
        return recommenderInfoDao.save(recommenderInfo);
    }

    @Override
    public QuestionnaireSurvey saveQuestionnaireSurvey(QuestionnaireSurvey questionnaireSurvey) {
        return questionnaireSurveyDao.save(questionnaireSurvey);
    }

    @Override
    public StudentHasAddress saveStudentHasAddress(StudentHasAddress studentHasAddress) {
        return studentHasAddressDao.save(studentHasAddress);
    }

    @Override
    public StudentHasEducationInfo saveStudentHasEducationInfo(StudentHasEducationInfo studentHasEducationInfo) {
        return studentHasEducationInfoDao.save(studentHasEducationInfo);
    }

    @Override
    public StudentHasRelationship saveStudentHasRelationship(StudentHasRelationship studentHasRelationship) {
        return studentHasRelationshipDao.save(studentHasRelationship);
    }

    @Override
    public StudentHasStandardizedTestAccountInfo saveStudentHasStandardizedTestAccountInfo(StudentHasStandardizedTestAccountInfo studentHasStandardizedTestAccountInfo) {
        return studentHasStandardizedTestAccountInfoDao.save(studentHasStandardizedTestAccountInfo);
    }

    @Override
    public StudentHasRecommenderInfo saveStudentHasRecommenderInfo(StudentHasRecommenderInfo studentHasRecommenderInfo) {
        return studentHasRecommenderInfoDao.save(studentHasRecommenderInfo);
    }

    @Override
    public StudentHasQuestionnaireSurvey saveStudentHasQuestionnaireSurvey(StudentHasQuestionnaireSurvey studentHasQuestionnaireSurvey) {
        return studentHasQuestionnaireSurveyDao.save(studentHasQuestionnaireSurvey);
    }

    @Override
    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
        return studentInfoDao.save(studentInfo);
    }

    @Override
    public void deleteAddress(Address address) {
        addressDao.delete(address);
    }

    @Override
    public void deleteEducationInfo(EducationInfo educationInfo) {
        educationInfoDao.delete(educationInfo);
    }

    @Override
    public void deleteRelationship(Relationship relationship) {
        relationshipDao.delete(relationship);
    }

    @Override
    public void deleteStandardizedTestAccountInfo(StandardizedTestAccountInfo standardizedTestAccountInfo) {
        standardizedTestAccountInfoDao.delete(standardizedTestAccountInfo);
    }

    @Override
    public void deleteRecommenderInfo(RecommenderInfo recommenderInfo) {
        recommenderInfoDao.delete(recommenderInfo);
    }

    @Override
    public void deleteQuestionnaireSurvey(QuestionnaireSurvey questionnaireSurvey) {
        questionnaireSurveyDao.delete(questionnaireSurvey);
    }

    @Override
    public void deleteStudentHasAddress(StudentHasAddress studentHasAddress) {
        studentHasAddressDao.delete(studentHasAddress);
    }

    @Override
    public void deleteStudentHasEducationInfo(StudentHasEducationInfo studentHasEducationInfo) {
        studentHasEducationInfoDao.delete(studentHasEducationInfo);
    }

    @Override
    public void deleteStudentHasRelationship(StudentHasRelationship studentHasRelationship) {
        studentHasRelationshipDao.delete(studentHasRelationship);
    }

    @Override
    public void deleteStudentHasStandardizedTestAccountInfo(StudentHasStandardizedTestAccountInfo studentHasStandardizedTestAccountInfo) {
        studentHasStandardizedTestAccountInfoDao.delete(studentHasStandardizedTestAccountInfo);
    }

    @Override
    public void deleteStudentHasRecommenderInfo(StudentHasRecommenderInfo studentHasRecommenderInfo) {
        studentHasRecommenderInfoDao.delete(studentHasRecommenderInfo);
    }

    @Override
    public void deleteStudentHasQuestionnaireSurvey(StudentHasQuestionnaireSurvey studentHasQuestionnaireSurvey) {
        studentHasQuestionnaireSurveyDao.delete(studentHasQuestionnaireSurvey);
    }
}