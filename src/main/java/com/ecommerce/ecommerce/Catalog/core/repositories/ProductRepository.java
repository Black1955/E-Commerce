package com.ecommerce.ecommerce.Catalog.core.repositories;

import java.util.List;

import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Page;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;

public interface ProductRepository {
    void save(Product product);
    Product getById(ProductId id);
    Page<Product> getByCategory(List<Name> categories,int page, int size);
    void delete(ProductId id);
    Page<Product> getRandom(int page, int size);
}
