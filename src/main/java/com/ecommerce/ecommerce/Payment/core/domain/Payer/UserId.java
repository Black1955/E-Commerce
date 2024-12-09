package com.ecommerce.ecommerce.Payment.core.domain.Payer;

import com.ecommerce.ecommerce.Shared.core.EntityId;

public class UserId extends EntityId<String> {
    public UserId(String value) {
        super(value);
    }
}
