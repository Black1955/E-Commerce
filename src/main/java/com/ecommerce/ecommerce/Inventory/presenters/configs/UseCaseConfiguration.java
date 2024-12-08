package com.ecommerce.ecommerce.Inventory.presenters.configs;

import com.ecommerce.ecommerce.Inventory.core.repositories.StockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;
import com.ecommerce.ecommerce.Inventory.core.usecases.*;
import com.ecommerce.ecommerce.Shared.core.transaction.TransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public StockService stockService(
            StockRepository stockRepository,
            StockHistoryRepository stockHistoryRepository,
            TransactionManager transactionManager
    ) {
        return new StockService(stockRepository,stockHistoryRepository,transactionManager);
    }

    @Bean
    public ReduceInStock reduceInStock(StockRepository stockRepository) {
        return new ReduceInStock(stockRepository);
    }

    @Bean
    public AddNewStockItem addNewStockItem(StockRepository stockRepository) {
        return new AddNewStockItem(stockRepository);
    }

    @Bean
    public IsInStock isInStock(StockRepository stockRepository) {
        return new IsInStock(stockRepository);
    }

    @Bean
    public IncreaseExistingStockQuantity increaseExistingStockQuantity(StockRepository stockRepository) {
        return new IncreaseExistingStockQuantity(stockRepository);
    }

    @Bean
    public RecordStockReductionHistory recordStockReductionHistory(StockHistoryRepository stockHistoryRepository) {
        return new RecordStockReductionHistory(stockHistoryRepository);
    }

    @Bean
    public RecordStockAdditionHistory recordStockAdditionHistory(StockHistoryRepository stockHistoryRepository) {
        return new RecordStockAdditionHistory(stockHistoryRepository);
    }
}
