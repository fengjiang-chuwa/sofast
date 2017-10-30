package com.sofast.application.model;

import javax.persistence.*;

@Entity
@Table(name = "student_has_address", schema = "so_fast", catalog = "")
@IdClass(StudentHasAddressPK.class)
public class StudentHasAddress {
    private String studentId;
    private String addressId;

    @Id
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "address_id")
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentHasAddress that = (StudentHasAddress) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        return result;
    }
}
