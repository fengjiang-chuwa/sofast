package com.sofast.application.service.impl;

import com.google.common.collect.Lists;
import com.sofast.application.dao.CountryDao;
import com.sofast.application.dao.StudentBasicDao;
import com.sofast.application.model.Country;
import com.sofast.application.model.QCountry;
import com.sofast.application.model.StudentBasic;
import com.sofast.application.service.StudentBasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentBasicServiceImpl extends BaseServiceImpl<StudentBasic, String> implements StudentBasicService {

    private final StudentBasicDao studentBasicDao;
    private final CountryDao countryDao;

    @Autowired
    public StudentBasicServiceImpl(StudentBasicDao studentBasicDao, CountryDao countryDao) {
        this.studentBasicDao = studentBasicDao;
        this.crudRepository = studentBasicDao;
        this.countryDao = countryDao;
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

    @Override
    public List<Country> findAllCountryList(){
        Sort sort = new Sort(Sort.Direction.ASC, QCountry.country.name.toString());
        Iterable<Country> countryList = countryDao.findAll(sort);
        return Lists.newArrayList(countryList);
    }
}