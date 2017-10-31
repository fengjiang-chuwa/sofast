package com.sofast.application.dao;

import com.sofast.application.model.RecommenderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RecommenderInfoDao extends CrudRepository<RecommenderInfo, String> {
    List<RecommenderInfo> findAllById(List<String> ids);
}