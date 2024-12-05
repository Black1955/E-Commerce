package com.ecommerce.ecommerce.Catalog.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.CategoryId;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;
import com.ecommerce.ecommerce.Catalog.core.repositories.CategoryRepository;

import java.util.UUID;

public class CreateCategory {
    private final CategoryRepository categoryRepository;
    public CreateCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    void execute(Category category) {
        if(category == null) {
            throw new IllegalArgumentException("category cannot be empty");
        }
        if (category.getId() == null) {
            category.setId(new CategoryId(UUID.randomUUID().toString()));
        }
        this.categoryRepository.add(category);
    }
}
