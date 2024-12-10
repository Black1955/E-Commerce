package com.ecommerce.ecommerce.Order.presenters.rest;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.events.OrderPlaced;
import com.ecommerce.ecommerce.Order.core.usecases.PlaceOrder;
import com.ecommerce.ecommerce.Order.presenters.DTO.OrderCreateDTO;
import com.ecommerce.ecommerce.Order.presenters.mappers.OrderMapper;
import com.ecommerce.ecommerce.Shared.core.events.EventPublisher;
import com.ecommerce.ecommerce.Shared.core.transaction.TransactionManager;
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
    private final EventPublisher eventPublisher;
    private final TransactionManager transactionManager;

    public OrderController(PlaceOrder placeOrder, EventPublisher eventPublisher, TransactionManager transactionManager) {
        this.placeOrder = placeOrder;
        this.eventPublisher = eventPublisher;
        this.transactionManager = transactionManager;
    }

    //create
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid OrderCreateDTO order) {
            Order savedOrder = placeOrder.execute(OrderMapper.toDomain(order));
            eventPublisher.publish(new OrderPlaced(savedOrder.getId()));
            return ResponseEntity.status(HttpStatus.CREATED).body("Order saved");
    }
    //get by id
    //get by status
    // change status
    // get user orders
    // get user orders by status
}
