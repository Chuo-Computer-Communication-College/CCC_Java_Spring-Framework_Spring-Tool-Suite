package com.tuyano.springboot;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao<T> extends Serializable
{
    public List<T> getAll();
    
    public List<T> findByName(String name);
    
    public T findById(long id);
}
