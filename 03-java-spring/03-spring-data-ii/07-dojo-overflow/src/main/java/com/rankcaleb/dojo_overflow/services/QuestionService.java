package com.rankcaleb.dojo_overflow.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rankcaleb.dojo_overflow.models.Answer;
import com.rankcaleb.dojo_overflow.models.Question;
import com.rankcaleb.dojo_overflow.models.Tag;
import com.rankcaleb.dojo_overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
private final QuestionRepository questionRepo;
	
	public QuestionService( QuestionRepository questionRepo ) { this.questionRepo = questionRepo;}
	
	public List<Question> allQuestions() { return questionRepo.findAll(); }
	public Question createQuestion( Question value ) { return questionRepo.save( value ); }
	public Question findQuestion( Long id ) {
		Optional<Question> optional = questionRepo.findById( id );
		if ( optional.isPresent() ) { return optional.get(); }
		else { return null; }
	}
	public Question updateQuestion( Long id, String question, List<Answer> answers, List<Tag> tags, Date createdAt, Date updatedAt ) {
		Question value = new Question( id, question, answers, tags, createdAt, updatedAt );
		return questionRepo.save( value );
	}
	public Question updateQuestion( Question value ) { return questionRepo.save( value ); }
	public void deleteQuestion( Long id ) { questionRepo.deleteById( id ); }
}
