package com.sofast.application.entity.response;

import com.sofast.application.model.Address;
import com.sofast.application.model.EducationInfo;
import com.sofast.application.model.Phone;
import lombok.Data;

import java.util.Date;

@Data
public class EducationInfoData {
    private String id;
    private String schoolName;
    private String type;
    private String levelOfStudy;
    private String addressId;
    private String phoneId;
    private Date startDate;
    private Date endDate;
    private Address address;
    private Phone phone;

    public void setEducationInfoData(EducationInfo educationInfo) {
        this.id = educationInfo.getId();
        this.schoolName = educationInfo.getSchoolName();
        this.type = educationInfo.getType();
        this.levelOfStudy = educationInfo.getLevelOfStudy();
        this.addressId = educationInfo.getAddressId();
        this.phoneId = educationInfo.getPhoneId();
        this.startDate = educationInfo.getStartDate();
        this.endDate = educationInfo.getEndDate();
    }

    public EducationInfo toEducationInfo(EducationInfoData educationInfoData) {
        EducationInfo educationInfo = new EducationInfo();
        educationInfo.setId(educationInfoData.getId());
        educationInfo.setSchoolName(educationInfoData.getSchoolName());
        educationInfo.setType(educationInfoData.getType());
        educationInfo.setLevelOfStudy(educationInfoData.getLevelOfStudy());
        educationInfo.setAddressId(educationInfoData.getAddressId());
        educationInfo.setPhoneId(educationInfoData.getPhoneId());
        educationInfo.setStartDate(educationInfoData.getStartDate());
        educationInfo.setEndDate(educationInfoData.getEndDate());
        return educationInfo;
    }
}