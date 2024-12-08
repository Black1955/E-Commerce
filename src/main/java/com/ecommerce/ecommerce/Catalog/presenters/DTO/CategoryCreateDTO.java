package com.ecommerce.ecommerce.Catalog.presenters.DTO;

import jakarta.validation.constraints.NotBlank;

public class CategoryCreateDTO {
    @NotBlank
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
