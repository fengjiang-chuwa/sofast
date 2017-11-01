package com.sofast.application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_info", schema = "so_fast", catalog = "")
public class StudentInfo {
    private String id;
    private String studentBasicId;
    private Date createdAt;
    private String programType;
    private Date startDate;
    private String targetSchool;
    private String firstChoice;
    private String secondChoice;
    private String safetyChoice;
    private String undecided;
    private String passport;
    private String academicTranscript;
    private String englishLanguageReport;
    private String existingI20;
    private String personalStatement;
    private String cv;
    private String certificate;
    private String applicantEmailAddress;
    private Date countryOfBirth;
    private Date dateOfBirth;
    private String nationality;
    private String passportNumber;
    private String nameOfHighestQualification;
    private Boolean declarationAgree;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_basic_id")
    public String getStudentBasicId() {
        return studentBasicId;
    }

    public void setStudentBasicId(String studentBasicId) {
        this.studentBasicId = studentBasicId;
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
    @Column(name = "program_type")
    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "target_school")
    public String getTargetSchool() {
        return targetSchool;
    }

    public void setTargetSchool(String targetSchool) {
        this.targetSchool = targetSchool;
    }

    @Basic
    @Column(name = "first_choice")
    public String getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(String firstChoice) {
        this.firstChoice = firstChoice;
    }

    @Basic
    @Column(name = "second_choice")
    public String getSecondChoice() {
        return secondChoice;
    }

    public void setSecondChoice(String secondChoice) {
        this.secondChoice = secondChoice;
    }

    @Basic
    @Column(name = "safety_choice")
    public String getSafetyChoice() {
        return safetyChoice;
    }

    public void setSafetyChoice(String safetyChoice) {
        this.safetyChoice = safetyChoice;
    }

    @Basic
    @Column(name = "undecided")
    public String getUndecided() {
        return undecided;
    }

    public void setUndecided(String undecided) {
        this.undecided = undecided;
    }

    @Basic
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "academic_transcript")
    public String getAcademicTranscript() {
        return academicTranscript;
    }

    public void setAcademicTranscript(String academicTranscript) {
        this.academicTranscript = academicTranscript;
    }

    @Basic
    @Column(name = "english_language_report")
    public String getEnglishLanguageReport() {
        return englishLanguageReport;
    }

    public void setEnglishLanguageReport(String englishLanguageReport) {
        this.englishLanguageReport = englishLanguageReport;
    }

    @Basic
    @Column(name = "existing_i20")
    public String getExistingI20() {
        return existingI20;
    }

    public void setExistingI20(String existingI20) {
        this.existingI20 = existingI20;
    }

    @Basic
    @Column(name = "personal_statement")
    public String getPersonalStatement() {
        return personalStatement;
    }

    public void setPersonalStatement(String personalStatement) {
        this.personalStatement = personalStatement;
    }

    @Basic
    @Column(name = "cv")
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Basic
    @Column(name = "certificate")
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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
    @Column(name = "country_of_birth")
    public Date getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(Date countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
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
    @Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "passport_number")
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "name_of_highest_qualification")
    public String getNameOfHighestQualification() {
        return nameOfHighestQualification;
    }

    public void setNameOfHighestQualification(String nameOfHighestQualification) {
        this.nameOfHighestQualification = nameOfHighestQualification;
    }

    @Basic
    @Column(name = "declaration_agree")
    public Boolean getDeclarationAgree() {
        return declarationAgree;
    }

    public void setDeclarationAgree(Boolean declarationAgree) {
        this.declarationAgree = declarationAgree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentInfo that = (StudentInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (studentBasicId != null ? !studentBasicId.equals(that.studentBasicId) : that.studentBasicId != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (programType != null ? !programType.equals(that.programType) : that.programType != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (targetSchool != null ? !targetSchool.equals(that.targetSchool) : that.targetSchool != null) return false;
        if (firstChoice != null ? !firstChoice.equals(that.firstChoice) : that.firstChoice != null) return false;
        if (secondChoice != null ? !secondChoice.equals(that.secondChoice) : that.secondChoice != null) return false;
        if (safetyChoice != null ? !safetyChoice.equals(that.safetyChoice) : that.safetyChoice != null) return false;
        if (undecided != null ? !undecided.equals(that.undecided) : that.undecided != null) return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
        if (academicTranscript != null ? !academicTranscript.equals(that.academicTranscript) : that.academicTranscript != null)
            return false;
        if (englishLanguageReport != null ? !englishLanguageReport.equals(that.englishLanguageReport) : that.englishLanguageReport != null)
            return false;
        if (existingI20 != null ? !existingI20.equals(that.existingI20) : that.existingI20 != null) return false;
        if (personalStatement != null ? !personalStatement.equals(that.personalStatement) : that.personalStatement != null)
            return false;
        if (cv != null ? !cv.equals(that.cv) : that.cv != null) return false;
        if (certificate != null ? !certificate.equals(that.certificate) : that.certificate != null) return false;
        if (applicantEmailAddress != null ? !applicantEmailAddress.equals(that.applicantEmailAddress) : that.applicantEmailAddress != null)
            return false;
        if (countryOfBirth != null ? !countryOfBirth.equals(that.countryOfBirth) : that.countryOfBirth != null)
            return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (passportNumber != null ? !passportNumber.equals(that.passportNumber) : that.passportNumber != null)
            return false;
        if (nameOfHighestQualification != null ? !nameOfHighestQualification.equals(that.nameOfHighestQualification) : that.nameOfHighestQualification != null)
            return false;
        if (declarationAgree != null ? !declarationAgree.equals(that.declarationAgree) : that.declarationAgree != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (studentBasicId != null ? studentBasicId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (programType != null ? programType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (targetSchool != null ? targetSchool.hashCode() : 0);
        result = 31 * result + (firstChoice != null ? firstChoice.hashCode() : 0);
        result = 31 * result + (secondChoice != null ? secondChoice.hashCode() : 0);
        result = 31 * result + (safetyChoice != null ? safetyChoice.hashCode() : 0);
        result = 31 * result + (undecided != null ? undecided.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (academicTranscript != null ? academicTranscript.hashCode() : 0);
        result = 31 * result + (englishLanguageReport != null ? englishLanguageReport.hashCode() : 0);
        result = 31 * result + (existingI20 != null ? existingI20.hashCode() : 0);
        result = 31 * result + (personalStatement != null ? personalStatement.hashCode() : 0);
        result = 31 * result + (cv != null ? cv.hashCode() : 0);
        result = 31 * result + (certificate != null ? certificate.hashCode() : 0);
        result = 31 * result + (applicantEmailAddress != null ? applicantEmailAddress.hashCode() : 0);
        result = 31 * result + (countryOfBirth != null ? countryOfBirth.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (nameOfHighestQualification != null ? nameOfHighestQualification.hashCode() : 0);
        result = 31 * result + (declarationAgree != null ? declarationAgree.hashCode() : 0);
        return result;
    }
}
