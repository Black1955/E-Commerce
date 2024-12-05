package com.ecommerce.ecommerce.Catalog.core.repositories;

import java.util.List;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Page;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;


/**
 * Repository interface for managing {@link Product} entities.
 */
public interface ProductRepository {

    /**
     * Saves a {@link Product} entity.
     * If the product already exists, it will be updated; otherwise, it will be inserted as a new product.
     *
     * @param product The {@link Product} entity to save.
     */
    void save(Product product);

    /**
     * Retrieves a {@link Product} by its unique identifier.
     *
     * @param id The {@link ProductId} of the product to retrieve.
     * @return The {@link Product} corresponding to the provided id.
     */
    Product getById(ProductId id);

    /**
     * Retrieves a paginated list of {@link Product} entities that belong to one or more specified categories.
     *
     * @param categories The list of {@link Name} objects representing the categories to filter by.
     * @param page The page number to retrieve, where 0 is the first page.
     * @param size The size of the page (number of products per page).
     * @return A {@link Page} containing List of @link Product} entities with size and page.
     * @throws IllegalArgumentException If page or size are invalid (e.g., page < 0 or size <= 0).
     */
    Page<Product> getByCategory(List<Name> categories, int page, int size);

    /**
     * Deletes a {@link Product} by its unique identifier.
     *
     * @param id The {@link ProductId} of the product to delete.
     */
    void delete(ProductId id);

    /**
     * Retrieves a paginated list of random {@link Product} entities.
     *
     * @param page The page number to retrieve, where 0 is the first page.
     * @param size The size of the page (number of products per page).
     * @return A {@link Page} containing randomly selected {@link Product} entities.
     */
    Page<Product> getRandom(int page, int size);
}