package com.ecommerce.ecommerce.Inventory.presenters.rest;

import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.InsufficientStockException;
import com.ecommerce.ecommerce.Inventory.core.domain.exceptions.StockNotFoundException;
import com.ecommerce.ecommerce.Inventory.core.usecases.AddNewStockItem;
import com.ecommerce.ecommerce.Inventory.core.usecases.IsInStock;
import com.ecommerce.ecommerce.Inventory.core.usecases.ReduceInStock;
import com.ecommerce.ecommerce.Inventory.presenters.DTO.ErrorResponseDTO;
import com.ecommerce.ecommerce.Inventory.presenters.DTO.StockDTO;
import com.ecommerce.ecommerce.Inventory.presenters.mappers.StockMapper;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class StockController {

    private final AddNewStockItem addNewStockItem;
    private final ReduceInStock reduceInStock;
    private final IsInStock isInStock;

    public StockController(AddNewStockItem addNewStockItem, ReduceInStock reduceInStock, IsInStock isInStock) {
        this.reduceInStock = reduceInStock;
        this.addNewStockItem = addNewStockItem;
        this.isInStock = isInStock;
    }
    // for admin
    @PostMapping("/add")
    public ResponseEntity<String> addInStock(@RequestBody @Valid StockDTO stock) {
        addNewStockItem.execute(StockMapper.toDomain(stock));
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/sub")
    public ResponseEntity<String> subInStock(@RequestBody @Valid StockDTO stock) {
        reduceInStock.execute(StockMapper.toDomain(stock));
        return ResponseEntity.ok("Stock updated successfully");
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<StockDTO> getById(@PathVariable String productId) {
        var check = isInStock.execute(new ProductId(productId));
        return ResponseEntity.ok().body(StockMapper.toDTO(check));
    }
}
