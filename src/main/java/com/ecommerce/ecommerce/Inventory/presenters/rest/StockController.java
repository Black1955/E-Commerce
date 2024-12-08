package com.ecommerce.ecommerce.Inventory.presenters.rest;

import com.ecommerce.ecommerce.Inventory.core.usecases.AddNewStockItem;
import com.ecommerce.ecommerce.Inventory.presenters.DTO.StockDTO;
import com.ecommerce.ecommerce.Inventory.presenters.mappers.StockMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class StockController {

    private final AddNewStockItem addNewStockItem;

    public StockController(AddNewStockItem addNewStockItem) {
        this.addNewStockItem = addNewStockItem;
    }
    // for admin
    @PostMapping("/add")
    public ResponseEntity<String> addInStock(@RequestBody @Valid StockDTO stock) {
        addNewStockItem.execute(StockMapper.toDomain(stock));
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
