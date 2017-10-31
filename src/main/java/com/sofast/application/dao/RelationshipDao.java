package com.sofast.application.dao;

import com.sofast.application.model.Relationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RelationshipDao extends CrudRepository<Relationship, String> {
    List<Relationship> findAllById(List<String> ids);
}