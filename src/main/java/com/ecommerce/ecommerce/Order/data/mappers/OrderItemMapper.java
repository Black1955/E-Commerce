package com.ecommerce.ecommerce.Order.data.mappers;

import com.ecommerce.ecommerce.Order.core.domain.Order.OrderItem;
import com.ecommerce.ecommerce.Order.core.domain.Order.ProductId;
import com.ecommerce.ecommerce.Order.data.entities.OrderItemEmbeddable;
import com.ecommerce.ecommerce.Order.data.entities.QuantityEmbeddable;
import com.ecommerce.ecommerce.Shared.core.Quantity;

public class OrderItemMapper {
    public static OrderItemEmbeddable toEmbeddable(OrderItem item) {
        return new OrderItemEmbeddable(
                item.getId().getValue(),
                new QuantityEmbeddable(item.getQuantity().getValue())
        );
    }

    public static OrderItem toDomain(OrderItemEmbeddable embeddable) {
        return new OrderItem(
                new ProductId(embeddable.getProductId()),
                new Quantity(embeddable.getQuantity().getQuantity())
        );
    }
}