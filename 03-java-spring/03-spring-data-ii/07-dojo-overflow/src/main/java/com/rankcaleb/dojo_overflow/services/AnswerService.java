package com.rankcaleb.dojo_overflow.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.dojo_overflow.models.Answer;
import com.rankcaleb.dojo_overflow.models.Question;
import com.rankcaleb.dojo_overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	private final AnswerRepository answerRepo;
	
	public AnswerService( AnswerRepository categoryRepo ) { this.answerRepo = categoryRepo;}
	
	public List<Answer> allAnswers() { return answerRepo.findAll(); }
	public Answer createAnswer( Answer value ) { return answerRepo.save( value ); }
	public Answer findAnswer( Long id ) {
		Optional<Answer> optionalAnswer = answerRepo.findById( id );
		if ( optionalAnswer.isPresent() ) { return optionalAnswer.get(); }
		else { return null; }
	}
	public Answer updateAnswer( Long id, String answer, Question question, Date createdAt, Date updatedAt ) {
		Answer value = new Answer( id, answer, question, createdAt, updatedAt );
		return answerRepo.save( value );
	}
	public Answer updateAnswer( Answer value ) { return answerRepo.save( value ); }
	public void deleteAnswer( Long id ) { answerRepo.deleteById( id ); }
}