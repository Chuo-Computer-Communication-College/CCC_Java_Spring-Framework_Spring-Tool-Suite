package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData>
{
    private static final long SERIAL_VERSION_UID = 1L;

    @PersistenceContext
    private EntityManager eManager;
    
    @Autowired
    MyDataDaoImpl mdDAO; 

    @Override
    public List<MyData> getAll()
    {
        Query qry = eManager.createQuery("FROM MyData");
        
        @SuppressWarnings("unchecked")
        List<MyData> lstMyData = qry.getResultList();
        
        eManager.close();
        
        return lstMyData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MyData> findByName(String name)
    {
        return (List<MyData>)eManager.createQuery("FROM MyData WHERE name = " + name).getResultList();
    }

    @Override
    public MyData findById(long id)
    {
        return (MyData)eManager.createQuery("FROM MyData WHERE id = " + id).getSingleResult();
    }
}
