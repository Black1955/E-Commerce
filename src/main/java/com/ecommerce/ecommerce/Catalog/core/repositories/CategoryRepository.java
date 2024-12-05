package com.ecommerce.ecommerce.Catalog.core.repositories;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;

import java.util.List;

public interface CategoryRepository {
    void add(Category category);
    void delete(Name name);
    List<Category> getAll();
    Category getByName(Name name);
}
