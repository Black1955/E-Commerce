package com.ecommerce.ecommerce.Inventory.presenters.rest;

import com.ecommerce.ecommerce.Inventory.core.usecases.AddNewStockItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class StockController {

    private final AddNewStockItem addNewStockItem;

    public StockController(AddNewStockItem addNewStockItem) {
        this.addNewStockItem = addNewStockItem;
    }

    // for admin
    public ResponseEntity<String> addInStock() {
        addNewStockItem.execute();
       return null;
    }

}
