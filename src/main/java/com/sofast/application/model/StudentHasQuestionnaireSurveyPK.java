package com.sofast.application.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StudentHasQuestionnaireSurveyPK implements Serializable {
    private String studentId;
    private String questionnaireSurveyId;

    @Column(name = "student_id")
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "questionnaire_survey_id")
    @Id
    public String getQuestionnaireSurveyId() {
        return questionnaireSurveyId;
    }

    public void setQuestionnaireSurveyId(String questionnaireSurveyId) {
        this.questionnaireSurveyId = questionnaireSurveyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasQuestionnaireSurveyPK that = (StudentHasQuestionnaireSurveyPK) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (questionnaireSurveyId != null ? !questionnaireSurveyId.equals(that.questionnaireSurveyId) : that.questionnaireSurveyId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (questionnaireSurveyId != null ? questionnaireSurveyId.hashCode() : 0);
        return result;
    }
}
