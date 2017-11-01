package com.sofast.application.dao;

import com.sofast.application.model.EducationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EducationInfoDao extends CrudRepository<EducationInfo, String> {
}