package com.ecommerce.ecommerce.Catalog.data.implementations;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;
import com.ecommerce.ecommerce.Catalog.core.repositories.ProductRepository;
import com.ecommerce.ecommerce.Catalog.data.JpaRepositories.JpaProductRepository;
import com.ecommerce.ecommerce.Catalog.data.entities.ProductEntity;
import com.ecommerce.ecommerce.Catalog.data.mappers.ProductMapper;
import com.ecommerce.ecommerce.Shared.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository productRepository;

    public ProductRepositoryImpl(JpaProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void save(Product product) {
        productRepository.save(ProductMapper.toEntity(product));
    }

    @Override
    public Product getById(ProductId id) {
        var product = productRepository.findById(id.getValue());
        return product.map(ProductMapper::toDomain).orElse(null);
    }
    @Override
    public Page<Product> getByCategory(List<Name> categories, int page, int size) {
        List<String> categoryNames = categories.stream().map(Name::value).toList();
        Pageable pages = PageRequest.of(page,size);
        org.springframework.data.domain.Page<ProductEntity> products = productRepository.findByCategories(categoryNames,pages);
        return new Page<>(page,size,products.stream().map(ProductMapper::toDomain).toList());
    }

    @Override
    public void delete(ProductId id) {
        productRepository.deleteById(id.getValue());
    }

    @Override
    public Page<Product> getRandom(int page, int size) {
        Pageable pages = PageRequest.of(page,size);
        var products = productRepository.findAll(pages);
        return new Page<>(page,size,products.stream().map(ProductMapper::toDomain).toList());
    }

    @Override
    public Page<Product> getByTitle(String title, int page, int size) {
        Pageable pages = PageRequest.of(page,size);
        var products = productRepository.findByTitleContainingIgnoreCase(title,pages);
        return new Page<>(page,size,products.stream().map(ProductMapper::toDomain).toList());
    }
}
