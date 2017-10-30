package com.sofast.application.dao;

import com.sofast.application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, String> {
    User findByEmailAndPassword(String email, String password);

    User findByAuthCode(String authCode);
}