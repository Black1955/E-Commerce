package com.ecommerce.ecommerce.Catalog.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;

import java.util.UUID;

public class GetProductById {
    private final ProductRepository productRepository;
    public GetProductById(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product execute(ProductId id) {
        return this.productRepository.getById(id);
    }
}
