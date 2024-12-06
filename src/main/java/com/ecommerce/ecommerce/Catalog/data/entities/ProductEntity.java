package com.ecommerce.ecommerce.Catalog.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    private String id;

    private String title;

    private String description;

    @Embedded
    private PriceEmbeddable price;

    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public PriceEmbeddable getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public void setPrice(PriceEmbeddable price) {
        this.price = price;
    }
}

