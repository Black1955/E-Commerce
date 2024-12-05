package com.ecommerce.ecommerce.Catalog.core.domain.category;

import com.ecommerce.ecommerce.Catalog.core.domain.EntityId;

public class Category {
    private EntityId<String> id;
    private String name;
    public Category(EntityId<String> id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public EntityId<String> getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
