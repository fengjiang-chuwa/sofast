package com.sofast.application.controller.mvc;

import com.sofast.application.service.StudentBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentBasicService studentBasicService;

	@GetMapping("/student/{linkId}")
	public String welcome(Map<String, Object> model, @PathVariable("linkId") String linkId) {
	    model.put("linkId", linkId);
//	    List<Country> allCountryList = studentBasicService.findAllCountryList();
//        model.put("allCountryList", allCountryList);
//        List<QuestionnaireSurvey> allQuestionnaireSurveyList = studentBasicService.findAllQuestionnaireSurveyList();
//        model.put("allQuestionnaireSurveyList", allQuestionnaireSurveyList);
//        StudentBasic studentBasic = studentBasicService.findByLinkId(linkId);
//        model.put("studentBasic", studentBasic);
//        StudentInfo studentInfo = studentBasicService.findStudentInfoByStudentBasicId(studentBasic.getId());
//        model.put("studentInfo", studentInfo);
//        List<StudentHasAddress> studentHasAddressList = studentBasicService.findStudentHasAddressList(studentBasic.getId());
//        if (!CollectionHelper.isEmptyOrNull(studentHasAddressList)) {
//            List<String> ids = Lists.newArrayList();
//            for (StudentHasAddress studentHasAddress : studentHasAddressList) {
//                ids.add(studentHasAddress.getAddressId());
//            }
//            List<Address> addressList = studentBasicService.findAddressList(ids);
//            model.put("addressList", addressList);
//        }
//        List<StudentHasRecommenderInfo> studentHasRecommenderInfoList = studentBasicService.findStudentHasRecommenderInfoList(studentBasic.getId());
//        if (!CollectionHelper.isEmptyOrNull(studentHasRecommenderInfoList)) {
//            List<String> ids = Lists.newArrayList();
//            for (StudentHasRecommenderInfo studentHasRecommenderInfo : studentHasRecommenderInfoList) {
//                ids.add(studentHasRecommenderInfo.getRecommenderInfoId());
//            }
//            List<RecommenderInfo> recommenderInfoList = studentBasicService.findRecommenderInfoList(ids);
//            model.put("recommenderInfoList", recommenderInfoList);
//        }
//        List<StudentHasRelationship> studentHasRelationshipList = studentBasicService.findStudentHasRelationshipList(studentBasic.getId());
//        if (!CollectionHelper.isEmptyOrNull(studentHasRelationshipList)) {
//            List<String> ids = Lists.newArrayList();
//            for (StudentHasRelationship studentHasRelationship : studentHasRelationshipList) {
//                ids.add(studentHasRelationship.getRelationshipId());
//            }
//            List<Relationship> relationshipList = studentBasicService.findRelationshipList(ids);
//            model.put("relationshipList", relationshipList);
//        }
//        List<StudentHasEducationInfo> studentHasEducationInfoList = studentBasicService.findStudentHasEducationInfoList(studentBasic.getId());
//        if (!CollectionHelper.isEmptyOrNull(studentHasEducationInfoList)) {
//            List<String> ids = Lists.newArrayList();
//            for (StudentHasEducationInfo studentHasEducationInfo : studentHasEducationInfoList) {
//                ids.add(studentHasEducationInfo.getEducationInfoId());
//            }
//            List<EducationInfo> educationInfoList = studentBasicService.findEducationInfoList(ids);
//            model.put("educationInfoList", educationInfoList);
//        }
//        List<StudentHasQuestionnaireSurvey> studentHasQuestionnaireSurveyList = studentBasicService.findStudentHasQuestionnaireSurveyList(studentBasic.getId());
//        if (!CollectionHelper.isEmptyOrNull(studentHasQuestionnaireSurveyList)) {
//            List<String> ids = Lists.newArrayList();
//            for (StudentHasQuestionnaireSurvey studentHasQuestionnaireSurvey : studentHasQuestionnaireSurveyList) {
//                ids.add(studentHasQuestionnaireSurvey.getQuestionnaireSurveyId());
//            }
//            List<QuestionnaireSurvey> questionnaireSurveyList = studentBasicService.findQuestionnaireSurveyList(ids);
//            model.put("questionnaireSurveyList", questionnaireSurveyList);
//        }
//        List<StudentHasStandardizedTestAccountInfo> studentHasStandardizedTestAccountInfoList = studentBasicService.findStudentHasStandardizedTestAccountInfoList(studentBasic.getId());
//        if (!CollectionHelper.isEmptyOrNull(studentHasStandardizedTestAccountInfoList)) {
//            List<String> ids = Lists.newArrayList();
//            for (StudentHasStandardizedTestAccountInfo studentHasStandardizedTestAccountInfo : studentHasStandardizedTestAccountInfoList) {
//                ids.add(studentHasStandardizedTestAccountInfo.getStandardizedTestAccountInfoId());
//            }
//            List<StandardizedTestAccountInfo> standardizedTestAccountInfoList = studentBasicService.findStandardizedTestAccountInfoList(ids);
//            model.put("standardizedTestAccountInfoList", standardizedTestAccountInfoList);
//        }
		return "student_input";
	}
}