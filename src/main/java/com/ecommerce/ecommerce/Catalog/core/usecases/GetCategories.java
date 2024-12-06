package com.ecommerce.ecommerce.Catalog.core.usecases;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.repositories.CategoryRepository;

import java.util.List;

public class GetCategories {
    private final CategoryRepository categoryRepository;
    public GetCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> execute() {
        return this.categoryRepository.getAll();
    }
}
