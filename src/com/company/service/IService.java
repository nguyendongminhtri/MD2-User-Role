package com.company.service;

import java.io.IOException;
import java.util.List;

public interface IService<T> {
    List<T> findAll() throws IOException;
    void save(T t);
    T findById(int id);
}
