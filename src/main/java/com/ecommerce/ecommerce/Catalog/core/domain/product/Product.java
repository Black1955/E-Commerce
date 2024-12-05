package com.ecommerce.ecommerce.Catalog.core.domain.product;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;

public class Product {
    private ProductId id;
    private Price price;
    private List<Category> categories = new ArrayList<>();
    private String title;
    private String description;

    public Product(ProductId id, Price price, List<Category> categories, String title, String description) {
        if(categories.isEmpty()) {
            throw new IllegalArgumentException("Product must have at least 1 category");
        }
        this.categories = categories;
        this.description = description;
        this.id = id;
        this.price = price;
        this.title = title;
    }
    public static Product createWithoutId(Price price, List<Category> categories, String title, String description) {
        return new Product(null, price, categories, title, description);
    }

    public void setId(ProductId id) {
        if (this.id != null) {
            throw new IllegalStateException("ID is already set");
        }
        this.id = id;
    }
    public ProductId getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
   public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
