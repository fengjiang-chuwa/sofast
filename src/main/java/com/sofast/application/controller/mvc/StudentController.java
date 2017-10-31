package com.sofast.application.controller.mvc;

import com.google.common.collect.Lists;
import com.sofast.application.model.Address;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.model.StudentHasAddress;
import com.sofast.application.model.StudentInfo;
import com.sofast.application.service.StudentBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentBasicService studentBasicService;

	@GetMapping("/student/{linkId}")
	public String welcome(Map<String, Object> model, @PathVariable("linkId") String linkId) {
        StudentBasic studentBasic = studentBasicService.findByLinkId(linkId);
        StudentInfo studentInfo = studentBasicService.findStudentInfoByStudentBasicId(studentBasic.getId());
        List<StudentHasAddress> studentHasAddressList = studentBasicService.findStudentHasAddressList(studentBasic.getId());
        List<String> ids = Lists.newArrayList();
        for(StudentHasAddress studentHasAddress : studentHasAddressList){
            ids.add(studentHasAddress.getAddressId());
        }
        List<Address> addressList = studentBasicService.findAddressList(ids);
		return "student_input";
	}
}