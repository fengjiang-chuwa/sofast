package com.sofast.application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_basic", schema = "so_fast", catalog = "")
public class StudentBasic {
    private String id;
    private String firstName;
    private String familyName;
    private String status;
    private Date createdAt;
    private Date dateOfBirth;
    private Date countryOfBirth;
    private String nationality;
    private String applicantEmailAddress;
    private String phoneId;
    private String email;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "family_name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "country_of_birth")
    public Date getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(Date countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    @Basic
    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "applicant_email_address")
    public String getApplicantEmailAddress() {
        return applicantEmailAddress;
    }

    public void setApplicantEmailAddress(String applicantEmailAddress) {
        this.applicantEmailAddress = applicantEmailAddress;
    }

    @Basic
    @Column(name = "phone_id")
    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentBasic that = (StudentBasic) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (familyName != null ? !familyName.equals(that.familyName) : that.familyName != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (countryOfBirth != null ? !countryOfBirth.equals(that.countryOfBirth) : that.countryOfBirth != null)
            return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (applicantEmailAddress != null ? !applicantEmailAddress.equals(that.applicantEmailAddress) : that.applicantEmailAddress != null)
            return false;
        if (phoneId != null ? !phoneId.equals(that.phoneId) : that.phoneId != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (countryOfBirth != null ? countryOfBirth.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (applicantEmailAddress != null ? applicantEmailAddress.hashCode() : 0);
        result = 31 * result + (phoneId != null ? phoneId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
