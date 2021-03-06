package com.tuyano.springboot;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="mydata")
@XmlRootElement
public class MyData
{
    @Column(nullable = true)
    @Min(value = 0)
    @Max(value = 200)
    private Integer age;
    
    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL)
    private List<MessageData> messageData;
    
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @NotNull
    private long id;
    
    @Column(length = 50, nullable = false)
    @NotEmpty
    private String name;
    
    @Column(length = 200, nullable = true)
    @Email
    private String mail;
    
    @Column(nullable = true)
    private String memo;

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public List<MessageData> getMessageData()
    {
        return messageData;
    }

    public void setMessageData(List<MessageData> messageData)
    {
        this.messageData = messageData;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }
}
