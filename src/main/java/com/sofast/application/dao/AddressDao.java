package com.sofast.application.dao;

import com.sofast.application.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AddressDao extends CrudRepository<Address, String> {
}