package com.ecommerce.ecommerce.Catalog.presenters.mappers;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.CategoryId;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.presenters.DTO.CategoryDTO;

import java.util.List;

public class CategoryMapper {
    public static List<CategoryDTO> mapToCategoryResponseDTO(List<Category> categories) {
        return categories.stream()
                .map(category -> new CategoryDTO(
                        category.getId().getValue(),
                        category.getName().value()
                ))
                .toList();
    }
    public static List<Category> mapToCategoryFromCategoryDTO(List<CategoryDTO> categories) {
        return categories.stream()
                .map(categoryDTO ->
                        new Category(
                                new CategoryId(categoryDTO.getId()),
                                new Name(categoryDTO.getName())))
                .toList();
    }
    }