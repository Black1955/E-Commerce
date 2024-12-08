package com.ecommerce.ecommerce.Inventory.data.mappers;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistory;
import com.ecommerce.ecommerce.Inventory.core.domain.StockHistory.StockHistoryId;
import com.ecommerce.ecommerce.Inventory.data.entities.StockHistoryEntity;

public class StockHistoryMapper {
    public static StockHistory toDomain(StockHistoryEntity entity) {
        if (entity == null) {
            return null;
        }

        return new StockHistory(
                new StockHistoryId(entity.getId()),
                new ProductId(entity.getProductId()),
                StockHistory.ChangeType.valueOf(entity.getChangeType().toString()),
                new Quantity(entity.getChangeAmount()),
                StockHistory.ReasonType.valueOf(entity.getReason().toString()),
                entity.getOrderId() != null ? new OrderId(entity.getOrderId()) : null
        );
    }

    public static StockHistoryEntity toEntity(StockHistory domain) {
        if (domain == null) {
            return null;
        }

        return new StockHistoryEntity(
                domain.getId() != null ? domain.getId().getValue() : null,
                domain.getProductId().getValue(),
                domain.getOrderId() != null ? domain.getOrderId().getValue() : null,
                StockHistoryEntity.ChangeType.valueOf(domain.getChangeType().toString()),
                domain.getChangeAmount().getValue(),
                StockHistoryEntity.ReasonType.valueOf(domain.getReason().toString()),
                domain.getTimestamp()
        );
    }
}
