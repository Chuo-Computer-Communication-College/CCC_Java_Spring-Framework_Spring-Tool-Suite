package com.tuyano.springboot;

class DataObject
{
    private int id;

    private String name;
    private String mail;
    
    public DataObject(int id, String name, String value)
    {
        super();
        
        this.id = id;
        this.name = name;
        this.mail = value;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }
}
