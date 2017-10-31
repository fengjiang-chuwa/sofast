package com.sofast.application.controller.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
public class StudentDetailController {

    @RequestMapping("/studentdetail/new")
    public String welcome(Map<String, Object> model) {
        return "addStudent";
    }
}
