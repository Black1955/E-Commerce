package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

public class ReduceInStock {
    private final StockRepository stockRepository;
    public ReduceInStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    Stock execute(Stock stock) {
        if(stock == null) {
            throw new IllegalArgumentException("stock cannot be empty");
        }
        return this.stockRepository.ReduceItems(stock);
    }
}
