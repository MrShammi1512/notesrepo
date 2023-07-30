package com.student.Student_Management.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Student_Management.dao.NotesDao;
import com.student.Student_Management.dao.StudentDao;
import com.student.Student_Management.dao.UserDao;
import com.student.Student_Management.entity.Notes;
import com.student.Student_Management.entity.Student;
import com.student.Student_Management.entity.User;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class NotesController {

	@Autowired
	private NotesDao notesDao;
	
	@Autowired
	private UserDao userDao;

	@GetMapping("/notes")
	public List<Notes> getAllNotes()
	{
		return notesDao.getAllNotes();
	}
	
	@GetMapping("/users")
	public List<User> getAllUser()
	{
		return this.userDao.getAllUsers();
	}
	
	@GetMapping("/notes/{useremail}")
	public List<Notes> getAllNotesByUser( @PathVariable String userEmail)
	{
		return this.notesDao.getNotesByUserEmail(userEmail);
	}

	@PostMapping("/notes")
	public Notes addNotesWithUser(@RequestBody Notes notes ) {
		//System.out.println(notes.getNotesid());
	    // Check if the user is provided in the request body
	    if (notes.getUser() == null) {
	        throw new RuntimeException("User is not provided for the notes.");
	    }

	    // Check if the user has a valid email
	    String userEmail = notes.getUser().getEmail();
	    if (userEmail == null || userEmail.isEmpty()) {
	        throw new RuntimeException("User email is missing in the request.");
	    }

	    // Check if the user exists
	    User user = userDao.getUserByEmail(userEmail);
	    if (user == null) {
	        throw new RuntimeException("User not found with email: " + userEmail);
	    }

	    notes.setUser(user); // Set the user in the notes object
	    return notesDao.addNotes(notes);
//		return notes;
	}
	
	@DeleteMapping("/notes/{notesid}")
	public ResponseEntity<String> deleteNotesById(@PathVariable long notesid) {
	    // Check if the notes with the given ID exists
	    Notes existingNotes = notesDao.getNotesById(notesid);

	    if (existingNotes == null) {
	        // If the notes does not exist, return a 404 Not Found response
	        return ResponseEntity.notFound().build();
	    }

	    // If the notes exists, delete it using the NotesDao
	    notesDao.deleteNotes(notesid);

	    // Return a 200 OK response
	    return ResponseEntity.ok().body("Notes with ID: " + notesid + " has been deleted.");
	}
	
	@PutMapping("/notes/{notesid}")
	public ResponseEntity<Notes> updateNotes(@PathVariable long notesid, @RequestBody Notes updatedNotes) {
	    // Check if the notes with the given ID exists
	    Notes existingNotes = notesDao.getNotesById(notesid);

	    if (existingNotes == null) {
	        // If the notes does not exist, return a 404 Not Found response
	        return ResponseEntity.notFound().build();
	    }

	    // Update the notes data with the provided data
	    existingNotes.setTitle(updatedNotes.getTitle());
	    existingNotes.setContent(updatedNotes.getContent());

	    // Save the updated notes using the NotesDao
	    notesDao.updateNotes(existingNotes);

	    // Return a 200 OK response with the updated notes
	    return ResponseEntity.ok(existingNotes);
	}

	


}
