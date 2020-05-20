package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("rawtypes")
public class MessageDataDaoImpl implements MessageDataDao<MessageData>
{
    private EntityManager eManager;
    
    public MessageDataDaoImpl()
    {
        super();
    }

    public MessageDataDaoImpl(EntityManager eManager)
    {
        this.eManager = eManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MessageData> getAll()
    {
        return eManager.createQuery("FROM MessageData").getResultList();
    }

    @Override
    public MessageData findById(long id)
    {
        return (MessageData)eManager.createQuery("FROM MessageData WHERE id = " + id).getSingleResult();
    }

}
