package com.sofast.application.controller.rest;

import com.google.common.collect.Lists;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.service.StudentBasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentRestController {

    private final StudentBasicService studentBasicService;

    @Autowired
    public StudentRestController(StudentBasicService studentBasicService) {
        this.studentBasicService = studentBasicService;
    }

    @GetMapping(value = "/studentdetail/search/result/")
    public List<StudentBasic> getCourse() throws MsgException {
        try {
            return studentBasicService.getList();
        } catch (Exception e) {
            log.error("getCourse", e);
            return Lists.newArrayList();
        }
    }

}
