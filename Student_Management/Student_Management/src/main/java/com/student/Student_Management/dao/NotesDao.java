package com.student.Student_Management.dao;

import java.util.List;

import com.student.Student_Management.entity.Notes;

public interface NotesDao {
    List<Notes> getAllNotes();

    Notes getNotesById(long notesid);

    List<Notes> getNotesByUserEmail(String userEmail); // New method to get all notes for a user

    Notes addNotes(Notes notes);

    void updateNotes(Notes notes);

    void deleteNotes(long notesid);
}
