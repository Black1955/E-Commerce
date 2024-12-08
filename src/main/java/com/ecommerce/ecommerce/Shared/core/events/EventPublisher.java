package com.ecommerce.ecommerce.Shared.core.events;

public interface EventPublisher {
    void publish(DomainEvent event);
}
