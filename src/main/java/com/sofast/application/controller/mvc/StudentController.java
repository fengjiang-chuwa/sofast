package com.sofast.application.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class StudentController {

	@GetMapping("/student/{email}")
	public String welcome(Map<String, Object> model, @PathVariable("email") String email) {

		return "student_input";
	}
}