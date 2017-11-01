package com.sofast.application.dao;

import com.sofast.application.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
//public interface CountryDao extends PagingAndSortingRepository<Country, Integer> {
public interface CountryDao extends JpaRepository<Country, Integer>, QueryDslPredicateExecutor<Country> {
}