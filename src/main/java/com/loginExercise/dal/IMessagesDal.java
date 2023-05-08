package com.loginExercise.dal;

import com.loginExercise.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface IMessagesDal extends CrudRepository<Message , Long> {


}
