package com.sofast.application.dao;

import com.sofast.application.model.StudentHasRelationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentHasRelationshipDao extends CrudRepository<StudentHasRelationship, String> {
    List<StudentHasRelationship> findAllByStudentId(String studentId);
}