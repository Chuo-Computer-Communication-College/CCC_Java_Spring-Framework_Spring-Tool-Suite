package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

@Service
public class MyDataService
{
    @PersistenceContext
    private EntityManager eManager;
    
    @SuppressWarnings("unchecked")
    public List<MyData> getAll()
    {
        return (List<MyData>)eManager.createQuery("FROM MyData").getResultList();
    }
    
    public List<MyData> find(String fstr)
    {
        CriteriaBuilder cBuilder = eManager.getCriteriaBuilder();
        
        CriteriaQuery<MyData> cQueryMyData = cBuilder.createQuery(MyData.class);
        
        Root<MyData> rootMyData = cQueryMyData.from(MyData.class);
        
        cQueryMyData.select(rootMyData).where(cBuilder.equal(rootMyData.get("name"), fstr));
        
        List<MyData> lstMyData = (List<MyData>)eManager.createQuery(cQueryMyData).getResultList();
        
        return lstMyData;
    }
    
    public MyData get(int number)
    {
        return (MyData)eManager.createQuery("FROM MyData WHERE id = " + number).getSingleResult();
    }
}
