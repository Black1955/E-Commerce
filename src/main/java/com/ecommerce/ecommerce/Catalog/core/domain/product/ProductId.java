package com.ecommerce.ecommerce.Catalog.core.domain.product;

import com.ecommerce.ecommerce.Catalog.core.domain.EntityId;

public class ProductId extends EntityId<String> {
    public ProductId(String value) {
        super(value);
    }
}
