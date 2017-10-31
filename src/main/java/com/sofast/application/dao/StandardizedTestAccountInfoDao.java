package com.sofast.application.dao;

import com.sofast.application.model.StandardizedTestAccountInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StandardizedTestAccountInfoDao extends CrudRepository<StandardizedTestAccountInfo, String> {
    List<StandardizedTestAccountInfo> findAllById(List<String> ids);
}