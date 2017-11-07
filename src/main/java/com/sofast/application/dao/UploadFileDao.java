package com.sofast.application.dao;

import com.sofast.application.model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
//public interface CountryDao extends PagingAndSortingRepository<Country, Integer> {
public interface UploadFileDao extends JpaRepository<UploadFile, String>, QueryDslPredicateExecutor<UploadFile> {
    UploadFile findById(String id);
}