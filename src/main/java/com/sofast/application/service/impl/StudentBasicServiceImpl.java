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
    private final EducationInfoDao educationInfoDao;
    private final QuestionnaireSurveyDao questionnaireSurveyDao;
    private final RecommenderInfoDao recommenderInfoDao;
    private final RelationshipDao relationshipDao;
    private final StandardizedTestAccountInfoDao standardizedTestAccountInfoDao;

    @Autowired
    public StudentBasicServiceImpl(StudentBasicDao studentBasicDao, CountryDao countryDao,
                                   AddressDao addressDao, StudentInfoDao studentInfoDao,
                                   EducationInfoDao educationInfoDao, QuestionnaireSurveyDao questionnaireSurveyDao,
                                   RecommenderInfoDao recommenderInfoDao, RelationshipDao relationshipDao,
                                   StandardizedTestAccountInfoDao standardizedTestAccountInfoDao) {
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
    }

    @Override
    public StudentBasic findById(String id) {
        return studentBasicDao.findById(id);
    }

    @Override
    public StudentInfo findStudentInfoByStudentBasicId(String studentBasicId) {
        return studentInfoDao.findByStudentBasicId(studentBasicId);
    }

    @Override
    public List<Country> findAllCountryList(){
        Sort sort = new Sort(Sort.Direction.ASC, QCountry.country.name.toString());
        Iterable<Country> countryList = countryDao.findAll(sort);
        return Lists.newArrayList(countryList);
    }

    @Override
    public List<Address> findAddressList(List<String> ids){
        return addressDao.findAllById(ids);
    }

    @Override
    public List<EducationInfo> findEducationInfoList(List<String> ids){
        return educationInfoDao.findAllById(ids);
    }

    @Override
    public List<QuestionnaireSurvey> findQuestionnaireSurveyList(List<String> ids){
        return questionnaireSurveyDao.findAllById(ids);
    }

    @Override
    public List<RecommenderInfo> findRecommenderInfoList(List<String> ids){
        return recommenderInfoDao.findAllById(ids);
    }

    @Override
    public List<Relationship> findRelationshipList(List<String> ids){
        return relationshipDao.findAllById(ids);
    }

    @Override
    public List<StandardizedTestAccountInfo> findStandardizedTestAccountInfoList(List<String> ids){
        return standardizedTestAccountInfoDao.findAllById(ids);
    }
}