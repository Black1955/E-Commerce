package com.ecommerce.ecommerce.Catalog.core.usecases;

import com.ecommerce.ecommerce.Shared.core.Page;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;
import com.ecommerce.ecommerce.Catalog.core.repositories.exceptions.RepositoryException;

public class GetProducts {
    private final ProductRepository productRepository;
    public GetProducts(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> execute(int size, int page) {
        if (page < 0) {
            throw new IllegalArgumentException("Page number cannot be negative.");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Page size must be greater than zero.");
        }
        try {
            return this.productRepository.getRandom(page, size);
        }
        catch(Exception e) {
            throw new RepositoryException("Failed to fetch products by category.", e);
        }
    }
}
