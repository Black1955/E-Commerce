package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

public class AddInStock {
    private final StockRepository stockRepository;
    public AddInStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    Stock execute(Stock stock) throws InsufficientStockException {
        if(stock == null) {
            throw new IllegalArgumentException("stock cannot be empty");
        }
        Stock check = this.stockRepository.checkQuantity(stock.getProductId());
        if(check.getQuantity().getValue() < stock.getQuantity().getValue()) {
            throw new InsufficientStockException(stock.getQuantity().getValue(),check.getQuantity().getValue());
        }
        return this.stockRepository.addItems(stock);
    }
}
