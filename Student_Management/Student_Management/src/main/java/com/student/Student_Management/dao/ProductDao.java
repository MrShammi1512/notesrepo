
package com.student.Student_Management.dao;

import java.util.List;

import com.student.Student_Management.entity.Product;

public interface ProductDao {

	Product getProductById(Long id);

    List<Product> getAllProducts();

    Product addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}
