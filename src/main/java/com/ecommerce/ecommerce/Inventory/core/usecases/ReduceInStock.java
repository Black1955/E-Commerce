package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

public class ReduceInStock {
    private final StockRepository stockRepository;
    public ReduceInStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public Stock execute(Stock stock) {
        if(stock == null) {
            throw new IllegalArgumentException("stock cannot be empty");
        }
        if(!isEnough(stock)) {
            throw new InsufficientStockException(stock.getQuantity().getValue(),stockRepository.checkQuantity(stock.getProductId()).map(stock1 -> stock1.getQuantity().getValue()).orElse(0));
        }
        return this.stockRepository.ReduceItems(stock);
    }
    private boolean isEnough(Stock stock) {
        return this.stockRepository.checkQuantity(stock.getProductId()).map(stock1 -> stock1.getQuantity().getValue() > stock.getQuantity().getValue()).orElse(false);
    }
}
