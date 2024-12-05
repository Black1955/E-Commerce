package com.ecommerce.ecommerce.Catalog.core.repositories;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;

import java.util.List;


public interface CategoryRepository {
    /**
     * method to create a Category
     * @param category type of {@link Category}
     */
    void add(Category category);

    /**
     *
     * @param name is the name of a {@link Category}
     * Type of {@link Name}
     */
    void delete(Name name);
    List<Category> getAll();

    /**
     * get a Category by {@link Name}
     * @param name is the name of a {@link Category}
     * @return {@link Category}
     */
    Category getByName(Name name);
}
