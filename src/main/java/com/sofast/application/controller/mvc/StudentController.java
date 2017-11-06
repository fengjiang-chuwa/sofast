package com.sofast.application.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class StudentController {
//    @Autowired
//    private StudentBasicService studentBasicService;

	@GetMapping("/student/{type}/{id}")
	public String welcome(Map<String, Object> model, @PathVariable("id") String id,
						  @PathVariable("type") String type) {
	    model.put("id", id);
	    model.put("type", type);
		return "student_input";
	}
}