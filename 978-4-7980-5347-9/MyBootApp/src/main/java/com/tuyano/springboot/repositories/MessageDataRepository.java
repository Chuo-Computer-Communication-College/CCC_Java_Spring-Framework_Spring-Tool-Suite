package com.tuyano.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.MessageData;

@Repository
public interface MessageDataRepository extends JpaRepository<MessageData, Long>
{

}
