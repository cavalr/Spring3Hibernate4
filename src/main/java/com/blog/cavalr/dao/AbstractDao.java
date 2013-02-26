package com.blog.cavalr.dao;

import java.io.Serializable;

public interface AbstractDao<E, I extends Serializable> {

    E findById(I id);
    void saveOrUpdate(E e);
    void delete(E e);
}
