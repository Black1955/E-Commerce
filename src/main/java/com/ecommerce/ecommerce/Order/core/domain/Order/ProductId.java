package com.ecommerce.ecommerce.Order.core.domain.Order;

import com.ecommerce.ecommerce.Shared.core.EntityId;

public class ProductId extends EntityId<String> {
    public ProductId(String value) {
        super(value);
    }
}
