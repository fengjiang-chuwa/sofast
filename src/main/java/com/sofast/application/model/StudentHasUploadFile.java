package com.sofast.application.model;

import javax.persistence.*;

@Entity
@Table(name = "student_has_upload_file", schema = "so_fast", catalog = "")
@IdClass(StudentHasUploadFilePK.class)
public class StudentHasUploadFile {
    private String studentId;
    private String uploadFileId;

    @Id
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "upload_file_id")
    public String getUploadFileId() {
        return uploadFileId;
    }

    public void setUploadFileId(String uploadFileId) {
        this.uploadFileId = uploadFileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasUploadFile that = (StudentHasUploadFile) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (uploadFileId != null ? !uploadFileId.equals(that.uploadFileId) : that.uploadFileId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (uploadFileId != null ? uploadFileId.hashCode() : 0);
        return result;
    }
}
