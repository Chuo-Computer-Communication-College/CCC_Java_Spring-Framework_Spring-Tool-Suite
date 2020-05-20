package com.tuyano.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>
{
    @Query("SELECT d FROM MyData d ORDER BY d.name")
    public List<MyData> findAllOrderByName();
    
    @Query("FROM MyData WHERE age > :min AND age < :max")
    public List<MyData> findByAge(@Param("min") int min, @Param("max") int max);
}
