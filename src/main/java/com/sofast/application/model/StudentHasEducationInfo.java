package com.sofast.application.model;

import javax.persistence.*;

@Entity
@Table(name = "student_has_education_info", schema = "so_fast", catalog = "")
@IdClass(StudentHasEducationInfoPK.class)
public class StudentHasEducationInfo {
    private String studentId;
    private String educationInfoId;

    @Id
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "education_info_id")
    public String getEducationInfoId() {
        return educationInfoId;
    }

    public void setEducationInfoId(String educationInfoId) {
        this.educationInfoId = educationInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasEducationInfo that = (StudentHasEducationInfo) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (educationInfoId != null ? !educationInfoId.equals(that.educationInfoId) : that.educationInfoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (educationInfoId != null ? educationInfoId.hashCode() : 0);
        return result;
    }
}
