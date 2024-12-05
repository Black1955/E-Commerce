package com.ecommerce.ecommerce.Catalog.core.domain.category;


/**
 * Category Entity
 */
public class Category {
    private CategoryId id;
    private String name;
    public Category(CategoryId id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CategoryId getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
