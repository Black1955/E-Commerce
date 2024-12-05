package com.ecommerce.ecommerce.Catalog.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Shared.Page;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;
import com.ecommerce.ecommerce.Catalog.core.repositories.exceptions.RepositoryException;

import java.util.List;


public class GetProductByCategory {

    private final ProductRepository productRepository;

    public GetProductByCategory(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> execute(List<Name> categoryNames, int page, int size) {
        if (categoryNames == null || categoryNames.isEmpty()) {
            throw new IllegalArgumentException("Category names cannot be empty.");
        }

        if (page < 0) {
            throw new IllegalArgumentException("Page number cannot be negative.");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Page size must be greater than zero.");
        }

        try {
            return productRepository.getByCategory(categoryNames, page, size);
        } catch (Exception e) {
            throw new RepositoryException("Failed to fetch products by category.", e);
        }
    }
}
