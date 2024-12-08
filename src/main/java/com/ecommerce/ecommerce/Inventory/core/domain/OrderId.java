package com.ecommerce.ecommerce.Inventory.core.domain;

import com.ecommerce.ecommerce.Shared.core.EntityId;

public class OrderId extends EntityId<String> {
    public OrderId(String value) {
        super(value);
    }
}
