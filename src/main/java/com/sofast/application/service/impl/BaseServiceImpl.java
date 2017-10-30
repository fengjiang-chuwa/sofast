package com.sofast.application.service.impl;

import com.google.common.collect.Lists;
import com.sofast.application.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fjiang
 * Date: 4/29/14
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public abstract class BaseServiceImpl<T,K extends Serializable> implements BaseService<T,K> {

    protected CrudRepository<T,K> crudRepository;

    @Override
    public T save(T t) {
        return crudRepository.save(t);
    }

    @Override
    public void delete(K id) {
        crudRepository.delete(id);
    }

    @Override
    public void delete(T t) {
        crudRepository.delete(t);
    }

    @Override
    public void deleteList(List<T> list) {
        crudRepository.delete(list);
    }

    @Override
    public List<T> getList() {
        log.info("Get List from mysql");
        return Lists.newArrayList(crudRepository.findAll());
    }
}
