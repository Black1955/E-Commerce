package com.ecommerce.ecommerce.Order.core.domain.Order;

import com.ecommerce.ecommerce.Shared.EntityId;

public class UserId extends EntityId<String> {
    public UserId(String value) {
        super(value);
    }
}
