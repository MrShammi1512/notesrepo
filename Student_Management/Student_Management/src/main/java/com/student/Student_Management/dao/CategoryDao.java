package com.student.Student_Management.dao;

import java.util.List;

import com.student.Student_Management.entity.Category;

public interface CategoryDao {

	
	 Category getCategoryById(Long id);

	    List<Category> getAllCategories();

	    Category addCategory(Category category);

	    void updateCategory(Category category);

	    void deleteCategory(Long id);
}
