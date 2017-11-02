package com.sofast.application.controller.rest;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.sofast.application.entity.JsonResponse;
import com.sofast.application.entity.enums.StudentSendStatus;
import com.sofast.application.entity.request.StudentBasicEntity;
import com.sofast.application.entity.response.EducationInfoData;
import com.sofast.application.entity.response.StudentHasQuestionnaireSurveyData;
import com.sofast.application.entity.response.StudentInputData;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.*;
import com.sofast.application.service.StudentBasicService;
import com.sofast.application.util.CollectionHelper;
import com.sofast.application.util.MailUtil;
import com.sofast.application.util.UUIDHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.List;

@Slf4j
@RestController
public class StudentRestController {

    private final StudentBasicService studentBasicService;

    private final MailUtil mailUtil;

    @Value("${mail.enroll.student.template}")
    private String mailTemplate;

    @Value("${mail.enroll.student.subject}")
    private String mailSubject;

    @Autowired
    public StudentRestController(StudentBasicService studentBasicService, MailUtil mailUtil) {
        this.studentBasicService = studentBasicService;
        this.mailUtil = mailUtil;
    }

    @GetMapping(value = "/studentdetail/search/result/")
    public List<StudentBasic> getCourse() throws MsgException {
        try {
            return studentBasicService.getList();
        } catch (Exception e) {
            log.error("getCourse", e);
            return Lists.newArrayList();
        }
    }

    @GetMapping(value = "/studentbasic/data/{studentBasicId}")
    public JsonResponse<StudentBasicEntity> getYearTerm(@PathVariable("studentBasicId") String studentBasicId)
            throws MsgException {
        try {
            StudentBasic studentBasic = studentBasicService.findById(studentBasicId);
            if (studentBasic == null) {
                return new JsonResponse<>(new StudentBasicEntity());
            } else {
                return new JsonResponse<>(new StudentBasicEntity(studentBasic));
            }
        } catch (Exception e) {
            log.error("saveCourse", e);
            return new JsonResponse<>(new StudentBasicEntity());
        }
    }

    @RequestMapping(value = "/studentbasic/save", method = RequestMethod.POST, produces = "application/json")
    public JsonResponse<String> saveCourse(@RequestBody StudentBasicEntity studentBasicEntity)
            throws MsgException {
        try {
            StudentBasic checkStudentBasic = studentBasicService.findByEmail(studentBasicEntity.getApplicantEmailAddress());
            if (checkStudentBasic != null) {
                if (!checkStudentBasic.getId().equalsIgnoreCase(studentBasicEntity.getId())) {
                    return new JsonResponse<>("The email has been already used.");
                }
            }
            if(Strings.isNullOrEmpty(studentBasicEntity.getId())){
                studentBasicEntity.setId(UUIDHelper.getUUID());
                studentBasicEntity.setStatus(StudentSendStatus.NEW.getKey());
                studentBasicEntity.setLinkId(UUIDHelper.getUUID());
            }
            StudentBasic studentBasic = new StudentBasic(studentBasicEntity);
            // TODO: 10/31/17 set phone number to phone id
            studentBasic.setPhoneId(studentBasicEntity.getPhoneNumber());
            studentBasicService.save(studentBasic);
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("saveCourse", e);
            return new JsonResponse<>("error");
        }
    }

    @GetMapping(value = "/student/send/mail/{studentBasicId}")
    public JsonResponse<String> sendEmail(@PathVariable("studentBasicId") String studentBasicId,
                                          HttpServletRequest request) throws MsgException {
        try {
            StudentBasic studentBasic = studentBasicService.findById(studentBasicId);
            if(studentBasic == null || Strings.isNullOrEmpty(studentBasic.getLinkId())){
                return new JsonResponse<>("error");
            }
            String link = request.getRequestURL().toString();
            link = link.substring(0, link.indexOf("/student/send/mail/"));
            link += "/student/" + studentBasic.getLinkId();
            String content = MessageFormat.format(mailTemplate, studentBasic.getFirstName(), link, link);
            mailUtil.send(studentBasic.getApplicantEmailAddress(), mailSubject, content);
            return new JsonResponse<>("success");
        } catch (Exception e) {
            log.error("sendEmail", e);
            return new JsonResponse<>("error");
        }
    }

    private void buildAddress(StudentInputData studentInputData) {
        Address homeAddress = new Address();
        homeAddress.setType("home");
        Address mailingAddress = new Address();
        mailingAddress.setType("mailing");
        List<Address> addressList = Lists.newArrayList();
        addressList.add(homeAddress);
        addressList.add(mailingAddress);
        studentInputData.setAddressList(addressList);
    }

    private void buildRelationship(StudentInputData studentInputData) {
        Relationship fRelationship = new Relationship();
        fRelationship.setRelationshipTitle("father");
        Relationship mRelationship = new Relationship();
        mRelationship.setRelationshipTitle("mother");
        List<Relationship> relationshipList = Lists.newArrayList();
        relationshipList.add(fRelationship);
        relationshipList.add(mRelationship);
        studentInputData.setRelationshipList(relationshipList);
    }

    @GetMapping(path = "/studentInput/data/{linkId}", produces = "application/json")
    public JsonResponse<StudentInputData> getStudentInputData(@PathVariable String linkId) {
        StudentInputData studentInputData = new StudentInputData();
        List<Country> allCountryList = studentBasicService.findAllCountryList();
        studentInputData.setAllCountryList(allCountryList);
        List<QuestionnaireSurvey> allQuestionnaireSurveyList = studentBasicService.findAllQuestionnaireSurveyList();
        studentInputData.setAllQuestionnaireSurveyList(allQuestionnaireSurveyList);
        StudentBasic studentBasic = studentBasicService.findByLinkId(linkId);
        studentInputData.setStudentBasic(studentBasic);
        StudentInfo studentInfo = studentBasicService.findStudentInfoByStudentBasicId(studentBasic.getId());
        studentInputData.setStudentInfo(studentInfo);
        List<StudentHasAddress> studentHasAddressList = studentBasicService.findStudentHasAddressList(studentBasic.getId());
        if (!CollectionHelper.isEmptyOrNull(studentHasAddressList)) {
            List<String> ids = Lists.newArrayList();
            for (StudentHasAddress studentHasAddress : studentHasAddressList) {
                ids.add(studentHasAddress.getAddressId());
            }
            List<Address> addressList = studentBasicService.findAddressList(ids);
            studentInputData.setAddressList(addressList);
        } else {
            buildAddress(studentInputData);
        }
        List<StudentHasRecommenderInfo> studentHasRecommenderInfoList = studentBasicService.findStudentHasRecommenderInfoList(studentBasic.getId());
        if (!CollectionHelper.isEmptyOrNull(studentHasRecommenderInfoList)) {
            List<String> ids = Lists.newArrayList();
            for (StudentHasRecommenderInfo studentHasRecommenderInfo : studentHasRecommenderInfoList) {
                ids.add(studentHasRecommenderInfo.getRecommenderInfoId());
            }
            List<RecommenderInfo> recommenderInfoList = studentBasicService.findRecommenderInfoList(ids);
            studentInputData.setRecommenderInfoList(recommenderInfoList);
        }
        List<StudentHasRelationship> studentHasRelationshipList = studentBasicService.findStudentHasRelationshipList(studentBasic.getId());
        if (!CollectionHelper.isEmptyOrNull(studentHasRelationshipList)) {
            List<String> ids = Lists.newArrayList();
            for (StudentHasRelationship studentHasRelationship : studentHasRelationshipList) {
                ids.add(studentHasRelationship.getRelationshipId());
            }
            List<Relationship> relationshipList = studentBasicService.findRelationshipList(ids);
            studentInputData.setRelationshipList(relationshipList);
        } else {
            buildRelationship(studentInputData);
        }
        List<StudentHasEducationInfo> studentHasEducationInfoList = studentBasicService.findStudentHasEducationInfoList(studentBasic.getId());
        if (!CollectionHelper.isEmptyOrNull(studentHasEducationInfoList)) {
            List<String> ids = Lists.newArrayList();
            for (StudentHasEducationInfo studentHasEducationInfo : studentHasEducationInfoList) {
                ids.add(studentHasEducationInfo.getEducationInfoId());
            }
            List<EducationInfo> educationInfoList = studentBasicService.findEducationInfoList(ids);
            List<EducationInfoData> educationInfoDataList = Lists.newArrayList();
            for (EducationInfo educationInfo : educationInfoList) {
                EducationInfoData educationInfoData = new EducationInfoData();
                educationInfoData.setEducationInfoData(educationInfo);
                Address address = studentBasicService.findAddressById(educationInfo.getAddressId());
                educationInfoData.setAddress(address);
                educationInfoDataList.add(educationInfoData);
            }
            studentInputData.setEducationInfoList(educationInfoDataList);
        }
        List<StudentHasQuestionnaireSurvey> studentHasQuestionnaireSurveyList = studentBasicService.findStudentHasQuestionnaireSurveyList(studentBasic.getId());
        List<StudentHasQuestionnaireSurveyData> studentHasQuestionnaireSurveyDataList = Lists.newArrayList();
        for (QuestionnaireSurvey questionnaireSurvey : allQuestionnaireSurveyList) {
            StudentHasQuestionnaireSurveyData studentHasQuestionnaireSurveyData = new StudentHasQuestionnaireSurveyData();
            studentHasQuestionnaireSurveyData.setQuestionnaireSurveyId(questionnaireSurvey.getId());
            studentHasQuestionnaireSurveyData.setStudentId(studentBasic.getId());
            studentHasQuestionnaireSurveyData.setQuestion(questionnaireSurvey.getQuestion());
            if (!CollectionHelper.isEmptyOrNull(studentHasQuestionnaireSurveyList)) {
                for (StudentHasQuestionnaireSurvey studentHasQuestionnaireSurvey : studentHasQuestionnaireSurveyList) {
                    if (questionnaireSurvey.getId().equalsIgnoreCase(studentHasQuestionnaireSurvey.getQuestionnaireSurveyId())) {
                        studentHasQuestionnaireSurveyData.setAnswer(studentHasQuestionnaireSurvey.getAnswer());
                        break;
                    }
                }
            }
            studentHasQuestionnaireSurveyDataList.add(studentHasQuestionnaireSurveyData);
        }
        studentInputData.setQuestionnaireSurveyList(studentHasQuestionnaireSurveyDataList);
        List<StudentHasStandardizedTestAccountInfo> studentHasStandardizedTestAccountInfoList = studentBasicService.findStudentHasStandardizedTestAccountInfoList(studentBasic.getId());
        if (!CollectionHelper.isEmptyOrNull(studentHasStandardizedTestAccountInfoList)) {
            List<String> ids = Lists.newArrayList();
            for (StudentHasStandardizedTestAccountInfo studentHasStandardizedTestAccountInfo : studentHasStandardizedTestAccountInfoList) {
                ids.add(studentHasStandardizedTestAccountInfo.getStandardizedTestAccountInfoId());
            }
            List<StandardizedTestAccountInfo> standardizedTestAccountInfoList = studentBasicService.findStandardizedTestAccountInfoList(ids);
            studentInputData.setStandardizedTestAccountInfoList(standardizedTestAccountInfoList);
        }
        return new JsonResponse<>(studentInputData);
    }
}