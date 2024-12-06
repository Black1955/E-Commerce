package com.ecommerce.ecommerce.Catalog.data.mappers;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.CategoryId;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.data.entities.CategoryEntity;

public class CategoryMapper {
    public static CategoryEntity toEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId().getValue());
        entity.setName(category.getName().value());

        return entity;
    }
    public static Category toDomain(CategoryEntity category) {
        return new Category(new CategoryId(category.getId()),new Name(category.getName()));
    }
}
