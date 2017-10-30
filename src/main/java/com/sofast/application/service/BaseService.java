package com.sofast.application.service;

import java.io.Serializable;
import java.util.List;

/*
 *
 * @author fjiang
 * @description 
 * @date 7/27/16
 */
public interface BaseService<T, K extends Serializable> {

    T save(T t);

    void delete(K id);

    void delete(T t);

    void deleteList(List<T> t);

    List<T> getList();
}
