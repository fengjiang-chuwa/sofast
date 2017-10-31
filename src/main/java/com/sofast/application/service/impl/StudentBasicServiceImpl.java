package com.sofast.application.service.impl;

import com.sofast.application.dao.StudentBasicDao;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.service.StudentBasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentBasicServiceImpl extends BaseServiceImpl<StudentBasic, String> implements StudentBasicService {

    private final StudentBasicDao studentBasicDao;

    @Autowired
    public StudentBasicServiceImpl(StudentBasicDao studentBasicDao) {
        this.studentBasicDao = studentBasicDao;
        this.crudRepository = studentBasicDao;
    }

    @Override
    public StudentBasic findById(String id) {
        return studentBasicDao.findById(id);
    }

    @Override
    public StudentBasic findByEmail(String email) {
        return studentBasicDao.findByEmail(email);
    }
}
