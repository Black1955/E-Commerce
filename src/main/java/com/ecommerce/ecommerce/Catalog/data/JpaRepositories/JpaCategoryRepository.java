package com.ecommerce.ecommerce.Catalog.data.JpaRepositories;

import com.ecommerce.ecommerce.Catalog.data.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, String> {
    void deleteByNameContainingIgnoreCase(String name);
    CategoryEntity findByNameContainingIgnoreCase(String name);
}
