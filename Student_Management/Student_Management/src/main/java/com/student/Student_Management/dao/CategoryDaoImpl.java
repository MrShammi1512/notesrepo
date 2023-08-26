package com.student.Student_Management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.Student_Management.entity.Category;
import com.student.Student_Management.entity.Product;
import com.student.Student_Management.exception.ReSourceNotFoundException;
import com.student.Student_Management.repo.CategoryRepo;

@Repository
public class CategoryDaoImpl implements CategoryDao {
   
	private CategoryRepo categoryRepo;

    public CategoryDaoImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new ReSourceNotFoundException("Category not found with ID: " + id));
	       
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        categoryRepo.save(category);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
      
	       Category  p= categoryRepo.findById(id).orElseThrow(() -> new ReSourceNotFoundException("Notes not found with ID: " + id));
	       categoryRepo.delete(p);
    }

}
