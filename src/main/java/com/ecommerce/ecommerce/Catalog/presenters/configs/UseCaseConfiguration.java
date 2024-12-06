package com.ecommerce.ecommerce.Catalog.presenters.configs;

import com.ecommerce.ecommerce.Catalog.core.repositories.CategoryRepository;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;
import com.ecommerce.ecommerce.Catalog.core.usecases.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateProduct createProductUseCase(ProductRepository productRepository) {
        return new CreateProduct(productRepository);
    }
    @Bean
    public CreateCategory createCategoryUseCase(CategoryRepository categoryRepository) {
        return new CreateCategory(categoryRepository);
    }
    @Bean
    public GetCategories getCategoriesUseCase(CategoryRepository categoryRepository) {
        return new GetCategories(categoryRepository);
    }
    @Bean
    public GetProductByCategory getProductByCategoryUseCase(ProductRepository productRepository) {
        return new GetProductByCategory(productRepository);
    }
    @Bean
    public GetProductById getProductByIdUseCase(ProductRepository productRepository) {
        return new GetProductById(productRepository);
    }
    @Bean
    public GetProducts getProductsUseCase(ProductRepository productRepository) {
        return new GetProducts(productRepository);
    }
}
