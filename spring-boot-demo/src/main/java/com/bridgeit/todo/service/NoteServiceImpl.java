package com.bridgeit.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.todo.dao.NoteDao;
import com.bridgeit.todo.model.DocDetails;
import com.bridgeit.todo.model.Note;
import com.bridgeit.todo.model.User;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteDao noteDao;
	
	public int saveNotes(Note note){
		return  noteDao.saveNotes(note);	
	}
	
	public List<Note> findAllNote(User user) {
		return noteDao.findAllNote(user);	
	}
	
	public Note getNoteById(int id) {
		return noteDao.getNoteById(id);
	}
	
	@Override
	public void deleteNoteById(int noteId){
		noteDao.deleteNoteById(noteId);	
	}

	public void updateNote(Note note) {
		noteDao.updateNote(note);
	}

	@Override
	public void updateNotes(int noteId, Note note) {
		     noteDao.updateNotes(noteId,note);
	}
	

	public List<DocDetails> getAllDoc(){
		return noteDao.getAllDoc();
	}
	
	public void saveDetails(DocDetails docDetails) {
		noteDao.saveDetails(docDetails);
	}
	
	public DocDetails getDocDetails(int id) {
		return noteDao.getDocDetails(id);
	}
}
