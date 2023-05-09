package com.loginExercise.dal;

import com.loginExercise.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMessagesDal extends CrudRepository<Message , Long> {


    Message findById(long id);

    @Query(value = "SELECT id, subject, context, sender, receiver,is_read FROM messages WHERE sender= :senderId", nativeQuery = true)
    List<Message> findAllBySenderId(@Param("senderId") long senderId);

    @Query(value = "SELECT id, subject, context, sender, receiver,is_read FROM messages WHERE receiver= :receiverId", nativeQuery = true)
    List<Message> findAllByReceiverId(@Param("receiverId")long receiverId);
}
