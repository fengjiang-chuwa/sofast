package com.sofast.application.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class StudentHasRelationshipPK implements Serializable {
    private String studentId;
    private String relationshipId;

    @Column(name = "student_id")
    @Id
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "relationship_id")
    @Id
    public String getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(String relationshipId) {
        this.relationshipId = relationshipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasRelationshipPK that = (StudentHasRelationshipPK) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (relationshipId != null ? !relationshipId.equals(that.relationshipId) : that.relationshipId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (relationshipId != null ? relationshipId.hashCode() : 0);
        return result;
    }
}
