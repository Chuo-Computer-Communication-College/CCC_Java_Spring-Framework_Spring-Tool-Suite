package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData>
{
    private static final long SERIAL_VERSION_UID = 1L;
    
    private EntityManager eManager;

    public MyDataDaoImpl()
    {
        super();
    }

    public MyDataDaoImpl(EntityManager eManager)
    {
        this();
        this.eManager = eManager;
    }

    @Override
    public List<MyData> getAll()
    {
        Query qry = eManager.createQuery("from MyData");
        
        @SuppressWarnings("unchecked")
        List<MyData> lstMyData = qry.getResultList();
        
        eManager.close();
        
        return lstMyData;
    }

}
