package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

import java.util.Optional;

public class AddInStock {
    private final StockRepository stockRepository;
    public AddInStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    Stock execute(Stock stock) throws InsufficientStockException {
        if(stock == null) {
            throw new IllegalArgumentException("stock cannot be empty");
        }
        Optional<Stock> check = this.stockRepository.getById(stock.getProductId());
        if(check.isPresent()) {
            Stock newStock = new Stock(stock.getProductId(),new Quantity(check.get().getQuantity().getValue() + stock.getQuantity().getValue()));
            return this.stockRepository.addItems(newStock);
        } else {
            return this.stockRepository.addItems(stock);
        }
    }
}
