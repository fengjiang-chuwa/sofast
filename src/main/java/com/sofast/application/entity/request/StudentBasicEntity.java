package com.sofast.application.entity.request;


import com.sofast.application.model.StudentBasic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentBasicEntity extends StudentBasic {

    private String phoneNumber;

    public StudentBasicEntity() {

    }
    public StudentBasicEntity(StudentBasic studentBasic) {
        BeanUtils.copyProperties(studentBasic, this);
        // TODO: 10/31/17 phone id phone number
        this.phoneNumber = studentBasic.getPhoneId();
    }
}
