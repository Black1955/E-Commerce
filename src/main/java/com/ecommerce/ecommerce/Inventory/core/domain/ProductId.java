package com.ecommerce.ecommerce.Inventory.core.domain;

import com.ecommerce.ecommerce.Shared.core.EntityId;

public class ProductId extends EntityId<String> {
    public ProductId(String value) {
        super(value);
    }
}
