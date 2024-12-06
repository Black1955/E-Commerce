package com.ecommerce.ecommerce.Catalog.presenters.DTO;

import java.util.List;


public class ProductCreateDTO {
    private String title;
    private String description;
    private float price;
    private List<CategoryDTO> categories;

    public ProductCreateDTO(String title, String description, float price, List<CategoryDTO> categories) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
