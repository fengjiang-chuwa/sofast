package com.sofast.application.entity.response;

import com.sofast.application.model.*;
import lombok.Data;

import java.util.List;

@Data
public class StudentInputData {
    private StudentBasic studentBasic;
    private StudentInfo studentInfo;
    private List<Country> allCountryList;
    private List<QuestionnaireSurvey> allQuestionnaireSurveyList;
    private List<Address> addressList;
    private List<RecommenderInfo> recommenderInfoList;
    private List<Relationship> relationshipList;
    private List<EducationInfoData> educationInfoList;
    private List<StudentHasQuestionnaireSurveyData> questionnaireSurveyList;
    private List<StandardizedTestAccountInfo> standardizedTestAccountInfoList;
    private List<UploadFile> uploadFileList;
}