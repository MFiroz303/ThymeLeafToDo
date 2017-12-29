package com.bridgeit.todo.service;

import java.util.List;

import com.bridgeit.todo.model.Note;
import com.bridgeit.todo.model.User;

public interface NoteService {

	public int saveNotes(Note note);

	public Note getNoteById(int id);

	public List<Note> findAllNote(User user);

}
