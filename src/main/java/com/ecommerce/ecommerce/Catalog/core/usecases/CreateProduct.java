package com.ecommerce.ecommerce.Catalog.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.CategoryId;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;

import java.util.UUID;

public class CreateProduct {
    private final ProductRepository productRepository;
    public CreateProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    void execute(Product product) {
        if(product == null) {
            throw new IllegalArgumentException("product cannot be empty");
        }
        if (product.getId() == null) {
            product.setId(new ProductId(UUID.randomUUID().toString()));
        }
        for(Category category : product.getCategories()) {
            if(category.getId() == null) {
                category.setId(new CategoryId(UUID.randomUUID().toString()));
            }
        }
        productRepository.save(product);
    }
}
