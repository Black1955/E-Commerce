package com.ecommerce.ecommerce.Catalog.core.domain.category;


/**
 * Category Entity
 */
public class Category {
    private CategoryId id;
    private Name name;
    public Category(CategoryId id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public CategoryId getId() {
        return id;
    }
    public void setName(Name name) {
        this.name = name;
    }
}
