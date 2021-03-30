package com.cognizant.LearnTodayRESTAPI.dao;

import org.springframework.dao.DuplicateKeyException;

import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidTrainerIdException;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

public interface TrainerDao {
	int signUp(Trainer trainer) throws DuplicateKeyException;
	int updatePassWord(int trainerId, Trainer trainer) throws InvalidTrainerIdException;
}
