package com.sofast.application.service;

import com.sofast.application.model.StudentBasic;

public interface StudentBasicService extends BaseService<StudentBasic, String> {
    StudentBasic findById(String id);
    StudentBasic findByEmail(String email);
}
