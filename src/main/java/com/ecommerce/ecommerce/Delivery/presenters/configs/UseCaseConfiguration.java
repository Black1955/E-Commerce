package com.ecommerce.ecommerce.Delivery.presenters.configs;

import com.ecommerce.ecommerce.Delivery.core.repositories.DeliveryRepository;
import com.ecommerce.ecommerce.Delivery.core.usecases.CreateDelivery;
import com.ecommerce.ecommerce.Delivery.core.usecases.GetDelivery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("DeliveryUseCaseConfiguration")
public class UseCaseConfiguration {
    @Bean
    public CreateDelivery createDelivery(DeliveryRepository deliveryRepository) {
        return new CreateDelivery(deliveryRepository);
    }
    @Bean
    public GetDelivery getDelivery(DeliveryRepository deliveryRepository) {
        return new GetDelivery(deliveryRepository);
    }
}
