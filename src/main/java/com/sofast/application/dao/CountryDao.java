package com.sofast.application.dao;

import com.sofast.application.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CountryDao extends PagingAndSortingRepository<Country, Integer> {
}