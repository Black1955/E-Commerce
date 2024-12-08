package com.ecommerce.ecommerce.Inventory.data.implementations;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;
import com.ecommerce.ecommerce.Inventory.core.domain.Stock;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.StockNotFoundException;
import com.ecommerce.ecommerce.Inventory.core.repositories.StockRepository;
import com.ecommerce.ecommerce.Inventory.data.JpaRepositories.JpaStockRepository;
import com.ecommerce.ecommerce.Inventory.data.mappers.StockMapper;

import java.util.Optional;

public class StockRepositoryImpl implements StockRepository {
    private final JpaStockRepository stockRepository;

    public StockRepositoryImpl(JpaStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    @Override
    public Optional<Stock> checkQuantity(ProductId id) {
        var stock = this.stockRepository.findById(id.getValue());
        return stock.map(StockMapper::toDomain);
    }

    @Override
    public void SaveOrUpdateStockItem(Stock item) {
        var stock = this.stockRepository.findById(item.getProductId().getValue());
        if(stock.isPresent()) {
            Stock newStock = new Stock(item.getProductId(),new Quantity(stock.get().getQuantity() + item.getQuantity().getValue()));
            this.stockRepository.save(StockMapper.toEntity(newStock));
        } else {
            this.stockRepository.save(StockMapper.toEntity(item));
        }
    }

    @Override
    public Stock ReduceItems(Stock item) {
        return this.stockRepository.findById(item.getProductId().getValue())
                .map(existingStock -> {
                    int difference = existingStock.getQuantity() - item.getQuantity().getValue();
                    if (difference < 0) {
                        throw new InsufficientStockException(item.getQuantity().getValue(), existingStock.getQuantity());
                    }
                    existingStock.setQuantity(difference);
                    this.stockRepository.save(existingStock);
                    return new Stock(new ProductId(existingStock.getProductId()), new Quantity(difference));
                })
                .orElseThrow(() -> new StockNotFoundException("There is no item in inventory"));
    }

    @Override
    public Optional<Stock> getById(ProductId id) {
        var stock = this.stockRepository.findById(id.getValue());
        return stock.map(StockMapper::toDomain);
    }
}
