package com.sofast.application.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class StudentController {

	@GetMapping("/student/{linkId}")
	public String welcome(Map<String, Object> model, @PathVariable("linkId") String linkId) {

		return "student_input";
	}
}