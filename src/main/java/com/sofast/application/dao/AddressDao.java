package com.sofast.application.dao;

import com.sofast.application.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AddressDao extends CrudRepository<Address, String> {
    List<Address> findAll(List<String> ids);
}