package com.ecommerce.ecommerce.Order.core.domain.Order;

import com.ecommerce.ecommerce.Shared.core.EntityId;

public class UserId extends EntityId<String> {
    public UserId(String value) {
        super(value);
    }
}
