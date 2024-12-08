package com.ecommerce.ecommerce.Inventory.data.JpaRepositories;

import com.ecommerce.ecommerce.Inventory.data.entities.StockHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStockHistoryRepository extends JpaRepository<StockHistoryEntity, String> {
    void deleteAllByOrderId(String orderId);
}
