package com.tuyano.springboot;

import java.util.List;

public interface MessageDataDao<T>
{
    public List<MessageData> getAll();
    
    public MessageData findById(long id);
}
