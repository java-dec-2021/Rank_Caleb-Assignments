package com.rankcaleb.dojo_overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rankcaleb.dojo_overflow.models.Answer;
import com.rankcaleb.dojo_overflow.models.Question;
import com.rankcaleb.dojo_overflow.models.Tag;
import com.rankcaleb.dojo_overflow.services.AnswerService;
import com.rankcaleb.dojo_overflow.services.QuestionService;
import com.rankcaleb.dojo_overflow.services.TagService;

@Controller
public class QuestionsController {
	
	private final AnswerService answerService;
	private final QuestionService questionService;
	private final TagService tagService;
	public QuestionsController( AnswerService answerService, QuestionService questionService, TagService tagService )
	{ this.answerService = answerService; this.questionService = questionService; this.tagService = tagService; }
	
	// routing
	@RequestMapping( value="/", method=RequestMethod.GET )
	public String index() { return "redirect:/questions"; }
	
	@RequestMapping( value="/questions", method=RequestMethod.GET )
	public String questions( Model model ) {
		model.addAttribute( "questions", questionService.allQuestions() );
		return "questions.jsp";
	}
	
	@RequestMapping( value="/questions/new", method=RequestMethod.GET )
	public String newQuestion() { return "new_question.jsp"; }
	@RequestMapping( value="/questions/new", method=RequestMethod.POST )
	public String createQuestion( @RequestParam("question") String question, @RequestParam("tags") String tags ) {
		
		String[] ts = tags.split( "," );
		Question q = new Question( question );
		
		List<Tag> tl = new ArrayList<Tag>();
		if( ts.length > 3 ) {
			for( int i=0; i<3; i++ ) {
				tl.add( new Tag( ts[i].strip().toLowerCase()) );
			}
		}
		else {
			for( String t : ts ) {
				tl.add( new Tag(t.strip().toLowerCase()) );
			}
		}
		
		for( int i=0; i<tl.size(); i++ ) {
			Tag testTag = tagService.findTag( tl.get(i).getSubject() );
			
			if( testTag != null ) {
				tl.set(i, testTag );
			}
			
			else { tl.set(i, tagService.createTag( tl.get(i) ) ); }
		}
		
		q.setTags( tl );
		questionService.createQuestion( q );
		
		return "redirect:/questions/new";
	}
	
	@RequestMapping( value="/questions/{id}", method=RequestMethod.GET )
	public String question( Model model, @PathVariable("id") Long id ) {
		model.addAttribute( "question", questionService.findQuestion( id ) );
		return "add_answers.jsp";
	}
	@RequestMapping( value="/questions/{id}", method=RequestMethod.POST )
	public String answer( @PathVariable("id") Long id, Model model, @RequestParam("answer") String answer ) {
		
		Answer a = new Answer( answer );
		Question q = questionService.findQuestion( id );
		a.setQuestion( q );
		answerService.createAnswer( a );
		return "redirect:/questions/" + id.toString();
	}
}