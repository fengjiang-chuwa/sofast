package com.sofast.application.model;

import javax.persistence.*;

@Entity
@Table(name = "student_has_relationship", schema = "so_fast", catalog = "")
@IdClass(StudentHasRelationshipPK.class)
public class StudentHasRelationship {
    private String studentId;
    private String relationshipId;

    @Id
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "relationship_id")
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

        StudentHasRelationship that = (StudentHasRelationship) o;

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
