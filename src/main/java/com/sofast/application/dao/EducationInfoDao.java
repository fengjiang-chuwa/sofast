package com.sofast.application.dao;

import com.sofast.application.model.EducationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EducationInfoDao extends CrudRepository<EducationInfo, String> {
    List<EducationInfo> findAllById(List<String> ids);
}