package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

import java.util.Optional;

public class AddNewStockItem {
    private final StockRepository stockRepository;
    public AddNewStockItem(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public void execute(Stock stock) {
        if(stock == null) {
            throw new IllegalArgumentException("stock cannot be empty");
        }
        if(stock.getQuantity().getValue() < 0) {
            throw new IllegalArgumentException("quantity of item cannot be negative");
        }
             this.stockRepository.SaveOrUpdateStockItem(stock);
    }
}
