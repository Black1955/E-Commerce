package com.ecommerce.ecommerce.Inventory.presenters.configs;

import com.ecommerce.ecommerce.Inventory.core.repositories.StockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;
import com.ecommerce.ecommerce.Inventory.data.JpaRepositories.JpaStockHistoryRepository;
import com.ecommerce.ecommerce.Inventory.data.JpaRepositories.JpaStockRepository;
import com.ecommerce.ecommerce.Inventory.data.implementations.StockHistoryRepositoryImpl;
import com.ecommerce.ecommerce.Inventory.data.implementations.StockRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("inventoryRepositoryConfiguration")
public class RepositoryConfiguration {
    @Bean
    public StockRepository stockRepository(JpaStockRepository stockRepository) {
        return new StockRepositoryImpl(stockRepository);
    }
    @Bean
    public StockHistoryRepository stockHistoryRepository(JpaStockHistoryRepository stockHistoryRepository) {
        return new StockHistoryRepositoryImpl(stockHistoryRepository);
    }
}
