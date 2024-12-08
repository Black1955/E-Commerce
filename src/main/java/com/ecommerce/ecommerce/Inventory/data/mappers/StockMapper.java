package com.ecommerce.ecommerce.Inventory.data.mappers;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.data.entities.StockEntity;

public class StockMapper {
    public static Stock toDomain(StockEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Stock(
                new ProductId(entity.getProductId()),
                new Quantity(entity.getQuantity())
        );
    }

    public static StockEntity toEntity(Stock domain) {
        if (domain == null) {
            return null;
        }

        return new StockEntity(
                domain.getProductId().getValue(),
                domain.getQuantity().getValue()
        );
    }
}
