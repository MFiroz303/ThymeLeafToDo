package com.bridgeit.todo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridgeit.todo.model.ErrorMessage;
import com.bridgeit.todo.model.Note;
import com.bridgeit.todo.model.User;
import com.bridgeit.todo.service.NoteService;
import com.bridgeit.todo.service.UserService;

@Controller
public class NoteController {
	
	@Autowired
	NoteService noteService;

	@Autowired
	UserService userService;

	
	@RequestMapping(value = "/addNote/{id}", method = RequestMethod.POST)
	public ResponseEntity<ErrorMessage> saveNotes(@RequestBody Note note, @PathVariable int id) {

		ErrorMessage message = new ErrorMessage();
		User user1 = userService.getUserById(id);
		
		Date date = new Date();
		note.setCreatedDate(date);
		note.setModifiedDate(date);

		note.setUser(user1);
		int userId = noteService.saveNotes(note);

		if (userId != 0) {
			
			message.setResponseMessage("Data Successfully inserted ");
			return ResponseEntity.status(HttpStatus.CREATED).body(message);
		}
		message.setResponseMessage("Note could not be added");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
	}
	
	@RequestMapping(value = "/noteList", method = RequestMethod.GET)
	public ResponseEntity<List<Note>> findAllNote(int id) {
		
		    ErrorMessage message = new ErrorMessage();
		    User user = userService.getUserById(id);
		 if(user!=null) {
		     List<Note> notes = noteService.findAllNote(user);
	         return new  ResponseEntity<List<Note>>(notes, HttpStatus.OK);
		}
		     message.setResponseMessage("error to display the notes");
		     return new ResponseEntity<List<Note>>(HttpStatus.BAD_REQUEST);	
	}
}
