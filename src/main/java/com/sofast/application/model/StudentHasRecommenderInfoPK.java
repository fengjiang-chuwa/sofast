package com.sofast.application.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StudentHasRecommenderInfoPK implements Serializable {
    private String studentId;
    private String recommenderInfoId;

    @Column(name = "student_id")
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "recommender_info_id")
    @Id
    public String getRecommenderInfoId() {
        return recommenderInfoId;
    }

    public void setRecommenderInfoId(String recommenderInfoId) {
        this.recommenderInfoId = recommenderInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasRecommenderInfoPK that = (StudentHasRecommenderInfoPK) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (recommenderInfoId != null ? !recommenderInfoId.equals(that.recommenderInfoId) : that.recommenderInfoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (recommenderInfoId != null ? recommenderInfoId.hashCode() : 0);
        return result;
    }
}
