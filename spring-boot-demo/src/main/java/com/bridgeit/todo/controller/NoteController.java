package com.bridgeit.todo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	

	@RequestMapping("/home")
	public ModelAndView home(User user, HttpSession session, int id) {
		
		ModelAndView modelAndView=new ModelAndView("redirect:/home");
		User noteUser = userService.getUserById(id);
		modelAndView.addObject("user",user);
		List<Note> notes=noteService.findAllNote(noteUser);
		modelAndView.addObject("notes",notes);
		Note note=new Note();
		modelAndView.addObject("note",note);
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value= "/addNote", method = RequestMethod.POST)
	public ModelAndView addNote( HttpSession session, Note note) {
		

		//User noteUser = userService.getUserById(id);
		User noteUser=(User) session.getAttribute("user");
		Date date = new Date();
		note.setCreatedDate(date);
		note.setModifiedDate(date);	
		note.setUser(noteUser);
		noteService.saveNotes(note);
		List<Note> notes=noteService.findAllNote(noteUser);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("user",noteUser);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public ModelAndView deleteNote(@PathVariable int id, Note note, HttpSession session) {
		
		System.out.println("Inside delete");
		noteService.deleteNoteById(id);
		
		User noteUser=(User) session.getAttribute("user");
		List<Note> notes=noteService.findAllNote(noteUser);
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.setViewName("home");
		modelAndView.addObject("user",noteUser);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		return modelAndView;	
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public  ModelAndView update(@PathVariable int id,HttpSession session) {
	
		ModelAndView modelAndView=new ModelAndView();
		Note oldNote = noteService.getNoteById(id);
		modelAndView.addObject("note",oldNote);
		modelAndView.setViewName("updateNote");
		return modelAndView;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ModelAndView updateNote(Note note,HttpSession session)
	{
		User user=(User) session.getAttribute("user");
		ModelAndView modelAndView=new ModelAndView();
		
		Date date=new Date();
		note.setModifiedDate(date);
		note.setCreatedDate(date);
		Note oldNote = noteService.getNoteById(note.getNoteId());
		
		if(user!=null) {
			if (oldNote.getUser().getId() == user.getId()) {
				note.setUser(user);
				noteService.updateNote(note);
		    }
		}
		modelAndView.addObject("user1",user);
		List<Note> notes=noteService.findAllNote(user);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		modelAndView.setViewName("home");
		return modelAndView;
  }
	
	/*@RequestMapping(value = "view/{id}", headers=("content-type=multipart/*"), method = RequestMethod.GET)
    public ModelAndView viewMenu(Note note, @PathVariable int id, @RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes) {
 
		ModelAndView modelAndView =new ModelAndView();
		User user = userService.getUserById(id);
        ((RedirectAttributes) note).addAttribute("note", note.getNoteId());
      
        //add photo upload coding here.
 
        ((RedirectAttributes) note).addAttribute("image",note.getImage());
         System.out.println("File is:" + file.getName());
        return modelAndView;
    }*/
}
