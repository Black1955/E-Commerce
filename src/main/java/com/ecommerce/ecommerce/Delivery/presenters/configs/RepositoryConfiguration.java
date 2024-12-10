package com.ecommerce.ecommerce.Delivery.presenters.configs;

import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;
import com.ecommerce.ecommerce.Delivery.data.JpaRepositories.JpaDeliveryRepository;
import com.ecommerce.ecommerce.Delivery.data.implementations.DeliveryRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("DeliveryRepositoryConfiguration")
public class RepositoryConfiguration {
    @Bean
    DeliveryRepository deliveryRepository(JpaDeliveryRepository deliveryRepository) {
        return new DeliveryRepositoryImpl(deliveryRepository);
    }
}
