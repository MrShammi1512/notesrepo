package com.student.Student_Management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.Student_Management.entity.Product;
import com.student.Student_Management.exception.ReSourceNotFoundException;
import com.student.Student_Management.repo.ProductRepo;

@Repository
public class ProductDaoImpl implements ProductDao {

	
	 private ProductRepo productRepo;

	    public ProductDaoImpl(ProductRepo productRepo) {
	        this.productRepo = productRepo;
	    }

	    @Override
	    public Product getProductById(Long id) {
	        return productRepo.findById(id).orElseThrow(() -> new ReSourceNotFoundException("Notes not found with ID: " + id));
	       
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepo.findAll();
	    }

	    @Override
	    public Product addProduct(Product product) {
	        Product p= productRepo.save(product);
	        return p;
	    }

	    @Override
	    public void updateProduct(Product product) {
	        productRepo.save(product);
	    }

	    @Override
	    public void deleteProduct(Long id) {
	       
	       Product p= productRepo.findById(id).orElseThrow(() -> new ReSourceNotFoundException("Notes not found with ID: " + id));
	        productRepo.delete(p);
	    }
}
