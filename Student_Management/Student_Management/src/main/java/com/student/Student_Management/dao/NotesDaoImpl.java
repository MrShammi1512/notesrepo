package com.student.Student_Management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.Student_Management.entity.Notes;
import com.student.Student_Management.entity.User;
import com.student.Student_Management.exception.ReSourceNotFoundException;
import com.student.Student_Management.repo.NotesRepo;
import com.student.Student_Management.repo.UserRepo;

@Repository
public class NotesDaoImpl implements NotesDao {

    private final NotesRepo notesRepo;
    private final UserRepo userRepo;

    @Autowired
    public NotesDaoImpl(NotesRepo notesRepo, UserRepo userRepo) {
        this.notesRepo = notesRepo;
        this.userRepo = userRepo;
    }
	

    @Override
    public List<Notes> getAllNotes() {
        return notesRepo.findAll();
    }

    @Override
    public Notes getNotesById(long notesid) {
        return notesRepo.findById(notesid).orElseThrow(() -> new ReSourceNotFoundException("Notes not found with ID: " + notesid));
    }

    @Override
    public List<Notes> getNotesByUserEmail(String userEmail) {
        User user = userRepo.findByEmail(userEmail);
        return notesRepo.findByUser(user);
    }

    @Override
    public Notes addNotes(Notes notes) {
        
        return notesRepo.save(notes);
    }

    @Override
    public void updateNotes(Notes notes) {
        notesRepo.save(notes);
    }

    @Override
    public void deleteNotes(long notesid) {
        Notes notes = notesRepo.findById(notesid).orElseThrow(() -> new ReSourceNotFoundException("Notes not found with ID: " + notesid));
        notesRepo.delete(notes);
    }

}
