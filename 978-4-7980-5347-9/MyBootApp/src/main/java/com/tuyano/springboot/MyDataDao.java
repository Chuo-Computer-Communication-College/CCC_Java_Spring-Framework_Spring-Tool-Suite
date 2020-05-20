package com.tuyano.springboot;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao<T> extends Serializable
{
    public List<T> getAll();
    
    public List<T> find(String fstr);
    
    public List<T> findByAge(int min, int max);
    
    public List<T> findByName(String name);
    
    public T findById(long id);
}
