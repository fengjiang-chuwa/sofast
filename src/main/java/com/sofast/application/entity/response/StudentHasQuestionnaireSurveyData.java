package com.sofast.application.entity.response;

import lombok.Data;

@Data
public class StudentHasQuestionnaireSurveyData {
    private String studentId;
    private String questionnaireSurveyId;
    private String answer;
    private String question;
}