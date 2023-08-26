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

import com.student.Student_Management.dao.CategoryDao;
import com.student.Student_Management.dao.NotesDao;
import com.student.Student_Management.dao.ProductDao;
import com.student.Student_Management.dao.UserDao;
import com.student.Student_Management.dao.StudentDao;
import com.student.Student_Management.entity.Category;
import com.student.Student_Management.entity.Notes;
import com.student.Student_Management.entity.Product;
import com.student.Student_Management.entity.User;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/")
public class NotesController {

	@Autowired
	private NotesDao notesDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	

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
	
	
	// products and Category
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return productDao.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getAllProductById( @PathVariable Long id)
	{
		return this.productDao.getProductById(id);
	}
	
	@PostMapping("/products")
	public Product addprodcutsWithUser(@RequestBody Product p ) {
		//System.out.println(notes.getNotesid());
	    // Check if the user is provided in the request body
	    if (p.getCategory() == null) {
	        throw new RuntimeException("Category is not provided for the notes.");
	    }

	    // Check if the user has a valid email
	    Long id = p.getCategory().getId();
	    if (id == null ) {
	        throw new RuntimeException("Category id is missing in the request.");
	    }

	    // Check if the user exists
	    Category c =categoryDao.getCategoryById(id);
	    if (c == null) {
	        throw new RuntimeException("Category not found with id: " + id);
	    }

	    p.setCategory(c); // Set the user in the notes object
	    return productDao.addProduct(p);
//		return notes;
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable long productId) {
	    // Check if the notes with the given ID exists
	    Product existingProduct = productDao.getProductById(productId);

	    if (existingProduct == null) {
	        // If the notes does not exist, return a 404 Not Found response
	        return ResponseEntity.notFound().build();
	    }

	    // If the notes exists, delete it using the NotesDao
	    productDao.deleteProduct(productId);

	    // Return a 200 OK response
	    return ResponseEntity.ok().body("Product with ID: " + productId + " has been deleted.");
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateproduct(@PathVariable long productId, @RequestBody Product updatedProduct) {
	    // Check if the notes with the given ID exists
		Product existingProduct = productDao.getProductById(productId);

	    if (existingProduct == null) {
	        // If the notes does not exist, return a 404 Not Found response
	        return ResponseEntity.notFound().build();
	    }

	    // Update the notes data with the provided data
	    existingProduct.setName(updatedProduct.getName());
	    existingProduct.setPrice(updatedProduct.getPrice());

	    // Save the updated notes using the NotesDao
	    productDao.updateProduct(existingProduct);

	    // Return a 200 OK response with the updated notes
	    return ResponseEntity.ok(existingProduct);
	}
	
	

	


}
