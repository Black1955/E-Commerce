package com.ecommerce.ecommerce.Catalog.data.implementations;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.core.repositories.CategoryRepository;
import com.ecommerce.ecommerce.Catalog.data.JpaRepositories.JpaCategoryRepository;
import com.ecommerce.ecommerce.Catalog.data.mappers.CategoryMapper;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final JpaCategoryRepository categoryRepository;

    public CategoryRepositoryImpl(JpaCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(CategoryMapper.toEntity(category));
    }

    @Override
    public void delete(Name name) {
        categoryRepository.deleteByNameContainingIgnoreCase(name.value());
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toDomain).toList();
    }

    @Override
    public Category getByName(Name name) {
        return CategoryMapper.toDomain(categoryRepository.findByNameContainingIgnoreCase(name.value()));
    }
}
