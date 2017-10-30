package com.sofast.application.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StudentHasStandardizedTestAccountInfoPK implements Serializable {
    private String studentId;
    private String standardizedTestAccountInfoId;

    @Column(name = "student_id")
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "standardized_test_account_info_id")
    @Id
    public String getStandardizedTestAccountInfoId() {
        return standardizedTestAccountInfoId;
    }

    public void setStandardizedTestAccountInfoId(String standardizedTestAccountInfoId) {
        this.standardizedTestAccountInfoId = standardizedTestAccountInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasStandardizedTestAccountInfoPK that = (StudentHasStandardizedTestAccountInfoPK) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (standardizedTestAccountInfoId != null ? !standardizedTestAccountInfoId.equals(that.standardizedTestAccountInfoId) : that.standardizedTestAccountInfoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (standardizedTestAccountInfoId != null ? standardizedTestAccountInfoId.hashCode() : 0);
        return result;
    }
}
