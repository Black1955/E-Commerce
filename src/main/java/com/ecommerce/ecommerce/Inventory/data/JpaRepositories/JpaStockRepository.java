package com.ecommerce.ecommerce.Inventory.data.JpaRepositories;

import com.ecommerce.ecommerce.Inventory.data.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStockRepository extends JpaRepository<StockEntity, String> {
}
