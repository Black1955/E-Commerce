package com.ecommerce.ecommerce.Catalog.presenters.configs;

import com.ecommerce.ecommerce.Catalog.core.repositories.CategoryRepository;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;
import com.ecommerce.ecommerce.Catalog.data.JpaRepositories.JpaCategoryRepository;
import com.ecommerce.ecommerce.Catalog.data.JpaRepositories.JpaProductRepository;
import com.ecommerce.ecommerce.Catalog.data.implementations.CategoryRepositoryImpl;
import com.ecommerce.ecommerce.Catalog.data.implementations.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public CategoryRepository categoryRepository(JpaCategoryRepository jpaCategoryRepository) {
        return new CategoryRepositoryImpl(jpaCategoryRepository);
    }
    @Bean
    public ProductRepository productRepository(JpaProductRepository jpaProductRepository) {
        return new ProductRepositoryImpl(jpaProductRepository);
    }
}
