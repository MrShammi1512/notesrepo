package com.student.Student_Management.controller;

import java.util.List;

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
import com.student.Student_Management.dao.ProductDao;
import com.student.Student_Management.entity.Category;
import com.student.Student_Management.entity.Product;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/")

public class CategoryConroller {

	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	@GetMapping("/categories")
	public List<Category> getAllCategory()
	{
		return categoryDao.getAllCategories();
	}
	
	@GetMapping("/categories/{id}")
	public Category getAllCategoryById( @PathVariable Long id)
	{
		return this.categoryDao.getCategoryById(id);
	}
	
	@PostMapping("/categories")
	public Category addprodcutsWithUser(@RequestBody Category c ) {
		//System.out.println(notes.getNotesid());
	    // Check if the user is provided in the request body
	    if (c.getId() == null) {
	        throw new RuntimeException("Category is not provided for the product.");
	    }

	    
	    return categoryDao.addCategory(c);
//		return notes;
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable long id) {
	    // Check if the notes with the given ID exists
	    Category existingCategory = categoryDao.getCategoryById(id);

	    if (existingCategory == null) {
	        // If the notes does not exist, return a 404 Not Found response
	        return ResponseEntity.notFound().build();
	    }

	    // If the notes exists, delete it using the NotesDao
	    categoryDao.deleteCategory(id);

	    // Return a 200 OK response
	    return ResponseEntity.ok().body("Category with ID: " + id + " has been deleted.");
	}
	
	@PutMapping("/categories/{productId}")
	public ResponseEntity<Category> updateCategory(@PathVariable long categoryId, @RequestBody Category updatedCategory) {
	    // Check if the notes with the given ID exists
		Category existingCategory = categoryDao.getCategoryById(categoryId);

	    if (existingCategory == null) {
	        // If the notes does not exist, return a 404 Not Found response
	        return ResponseEntity.notFound().build();
	    }

	    // Update the notes data with the provided data
	    existingCategory.setId(updatedCategory.getId());
	    existingCategory.setName(updatedCategory.getName());

	    // Save the updated notes using the NotesDao
	    categoryDao.updateCategory(existingCategory);

	    // Return a 200 OK response with the updated notes
	    return ResponseEntity.ok(existingCategory);
	}
	
	
}
