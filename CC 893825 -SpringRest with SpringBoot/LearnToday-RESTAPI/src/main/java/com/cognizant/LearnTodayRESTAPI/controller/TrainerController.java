package com.cognizant.LearnTodayRESTAPI.controller;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.dao.TrainerDao;
import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidTrainerIdException;
import com.cognizant.LearnTodayRESTAPI.dao.impl.TrainerDaoImpl;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

	@PostMapping("/trainerSignUp")
	public ResponseEntity<Object> trainerSignUp(@RequestBody Trainer trainer){
		TrainerDao dao = new TrainerDaoImpl();
		try {
			dao.signUp(trainer);
			return new ResponseEntity<>(trainer, HttpStatus.CREATED);
		} catch (DuplicateKeyException e) {
			return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<Object> updatePassword( @RequestBody Trainer trainer){
		TrainerDao dao = new TrainerDaoImpl();
			try {
				dao.updatePassWord(trainer.getTrainerId(), trainer);
				return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
			} catch (InvalidTrainerIdException e) {
				e.printStackTrace();
				return new ResponseEntity<>("Searched data not found", HttpStatus.NOT_FOUND);
			}
	}
}
