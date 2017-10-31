package com.sofast.application.service;

import com.sofast.application.model.Country;
import com.sofast.application.model.StudentBasic;

import java.util.List;

public interface StudentBasicService extends BaseService<StudentBasic, String> {
    StudentBasic findById(String id);
    StudentBasic findByEmail(String email);

    List<Country> findAllCountryList();
}
