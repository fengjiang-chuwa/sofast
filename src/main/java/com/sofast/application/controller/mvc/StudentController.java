package com.sofast.application.controller.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class StudentController {
//    @Autowired
//    private StudentBasicService studentBasicService;

	@Value("${upload.maxSize}")
	private String maxSize;

	@Value("${upload.maxSize.value}")
	private String maxSizeValue;

	@GetMapping("/student/{type}/{id}")
	public String welcome(Map<String, Object> model, @PathVariable("id") String id,
						  @PathVariable("type") String type) {
	    model.put("id", id);
	    model.put("type", type);
	    model.put("maxSize", maxSize);
	    model.put("maxSizeValue", maxSizeValue);
		return "student_input";
	}
}