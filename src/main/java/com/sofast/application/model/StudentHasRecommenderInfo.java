package com.sofast.application.model;

import javax.persistence.*;

@Entity
@Table(name = "student_has_recommender_info", schema = "so_fast", catalog = "")
@IdClass(StudentHasRecommenderInfoPK.class)
public class StudentHasRecommenderInfo {
    private String studentId;
    private String recommenderInfoId;

    @Id
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "recommender_info_id")
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

        StudentHasRecommenderInfo that = (StudentHasRecommenderInfo) o;

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
