package com.ecommerce.ecommerce.Order.presenters.rest;

import com.ecommerce.ecommerce.Order.core.usecases.PlaceOrder;
import com.ecommerce.ecommerce.Order.presenters.DTO.OrderCreateDTO;
import com.ecommerce.ecommerce.Order.presenters.mappers.OrderMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final PlaceOrder placeOrder;

    public OrderController(PlaceOrder placeOrder) {
        this.placeOrder = placeOrder;
    }

    //create
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid OrderCreateDTO order) {
        System.out.println("controller");
        System.out.println(order.getAdress());
        placeOrder.execute(OrderMapper.toDomain(order));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //get by id
    //get by status
    // change status
    // get user orders
    // get user orders by status
}
