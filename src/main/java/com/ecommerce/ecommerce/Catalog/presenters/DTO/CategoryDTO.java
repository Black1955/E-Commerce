package com.ecommerce.ecommerce.Catalog.presenters.DTO;

public class CategoryDTO {
    private String id;
    private String name;

    public CategoryDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
