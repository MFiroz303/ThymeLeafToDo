package com.bridgeit.todo.dao;


import java.util.List;

import com.bridgeit.todo.model.DocDetails;
import com.bridgeit.todo.model.Note;
import com.bridgeit.todo.model.User;

public interface NoteDao {

	public int saveNotes(Note note);

	public Note getNoteById(int id);

	public User getUserByEmail(String email, User user);

	List<Note> findAllNote(User user);

	public void deleteNoteById(int noteId);

	public void updateNote(Note note);

	public void updateNotes(int noteId, Note note);

	//public void deleteNoteById(Note note);
	

	public List<DocDetails> getAllDoc();
	
	public void saveDetails(DocDetails docDetails);
	
	public DocDetails getDocDetails(int id);
	

}
