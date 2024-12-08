package com.ecommerce.ecommerce.Inventory.presenters.mappers;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.presenters.DTO.StockDTO;

public class StockMapper {
    public static StockDTO toDTO(Stock stock) {
        return new StockDTO(stock.getProductId().getValue(), stock.getQuantity().getValue());
    }
    public static Stock toDomain (StockDTO stock) {
        return new Stock(new ProductId(stock.getProductId()),new Quantity(stock.getQuantity()));
    }
}
