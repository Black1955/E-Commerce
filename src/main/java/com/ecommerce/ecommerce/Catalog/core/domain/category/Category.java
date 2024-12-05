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
    public static Category createWithoutId(Name name) {
        return new Category(null,name);
    }
    public void setId(CategoryId id) {
        if (this.id != null) {
            throw new IllegalStateException("ID is already set");
        }
        this.id = id;
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
