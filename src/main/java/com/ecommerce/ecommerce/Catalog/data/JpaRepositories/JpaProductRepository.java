package com.ecommerce.ecommerce.Catalog.data.JpaRepositories;

import com.ecommerce.ecommerce.Catalog.data.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {
    @Query("SELECT p FROM ProductEntity p JOIN p.categories c WHERE c.name IN :categories")
    Page<ProductEntity> findByCategories(List<String> categories, Pageable pageable);

    Page<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
