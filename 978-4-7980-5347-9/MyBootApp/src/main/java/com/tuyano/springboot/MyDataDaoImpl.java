package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDataDaoImpl implements MyDataDao<MyData>
{
    private static final long SERIAL_VERSION_UID = 1L;

    EntityManager eManager;
    
    @Autowired
    MyDataDaoImpl mdDAO; 

    @Override
    public List<MyData> getAll()
    {
        // 取り出す位置の指定
        int intOffset = 1;
        // 取り出す個数の指定
        int intLimit = 2;
        
        CriteriaBuilder cBuilder = eManager.getCriteriaBuilder();
        
        CriteriaQuery<MyData> cQueryMyData = cBuilder.createQuery(MyData.class);
        
        Root<MyData> rootMyData = cQueryMyData.from(MyData.class);
        
        cQueryMyData.select(rootMyData);
        
        List<MyData> lstMyData = (List<MyData>)eManager.createQuery(cQueryMyData).setFirstResult(intOffset).setMaxResults(intLimit).getResultList();
        
        return lstMyData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MyData> find(String fstr)
    {
        CriteriaBuilder cBuilder = eManager.getCriteriaBuilder();
        
        CriteriaQuery<MyData> cqMyData = cBuilder.createQuery(MyData.class);
        
        Root<MyData> rMyData = cqMyData.from(MyData.class);
        
        cqMyData.select(rMyData).where(cBuilder.equal(rMyData.get("name"), fstr));
        
        List<MyData> lstMyData = (List<MyData>)eManager.createQuery(cqMyData).getResultList();
        
        return lstMyData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MyData> findByAge(int min, int max)
    {
        return (List<MyData>)eManager.createNamedQuery("findByAge").setParameter("min", min).setParameter("max", max).getResultList();
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
