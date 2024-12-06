package com.ecommerce.ecommerce.Catalog.data.mappers;

import com.ecommerce.ecommerce.Catalog.core.domain.product.Price;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;
import com.ecommerce.ecommerce.Catalog.data.entities.PriceEmbeddable;
import com.ecommerce.ecommerce.Catalog.data.entities.ProductEntity;

public class ProductMapper {
    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId().getValue());
        entity.setDescription(product.getDescription());
        PriceEmbeddable price = new PriceEmbeddable();
        price.setValue(product.getPrice().getValue());
        entity.setPrice(price);
        entity.setTitle(product.getTitle());
        entity.setCategories(
                product.getCategories().stream().map(CategoryMapper::toEntity).toList()
        );
        return entity;
    }
    public static Product toDomain(ProductEntity product) {
        return new Product(
                new ProductId(product.getId()),
                new Price(product.getPrice().getValue()),
                product.getCategories().stream().map(CategoryMapper::toDomain).toList(),
                product.getTitle(),
                product.getDescription()
        );
    }
}
