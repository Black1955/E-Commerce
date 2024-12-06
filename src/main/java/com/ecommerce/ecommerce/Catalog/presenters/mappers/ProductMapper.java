package com.ecommerce.ecommerce.Catalog.presenters.mappers;

import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.presenters.DTO.ProductDTO;

public class ProductMapper {
    public static ProductDTO FromProductToProductDTO(Product product) {
        return new ProductDTO(
                product.getId().getValue(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice().getValue(),
                CategoryMapper.mapToCategoryResponseDTO(product.getCategories())
        );
    }
}
