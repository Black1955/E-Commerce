package com.ecommerce.ecommerce.Inventory.core.usecases;

import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.StockNotFoundException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;

import java.util.Optional;

public class IncreaseExistingStockQuantity {
    private final StockRepository stockRepository;
    public IncreaseExistingStockQuantity(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public void execute(Stock stock) {
        if(stock == null) {
            throw new IllegalArgumentException("stock cannot be empty");
        }
        Optional<Stock> check = stockRepository.getById(stock.getProductId());
        if(check.isPresent()) {
            Stock newStock = new Stock(
                    stock.getProductId(),
                    new Quantity(check.get().getQuantity().getValue() + stock.getQuantity().getValue()));
             this.stockRepository.SaveOrUpdateStockItem(newStock);
        } else {
            throw new StockNotFoundException("Stock item with the given product ID does not exist");
        }

    }
}
