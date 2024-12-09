package com.ecommerce.ecommerce.Payment.presenters.configs;

import com.ecommerce.ecommerce.Payment.core.repositories.PaymentRepository;
import com.ecommerce.ecommerce.Payment.data.JpaRepositories.JpaPaymentRepository;
import com.ecommerce.ecommerce.Payment.data.implementations.PaymentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("PaymentRepositoryConfiguration")
public class RepositoryConfiguration {
    @Bean
    public PaymentRepository paymentRepository(JpaPaymentRepository paymentRepository) {
        return new PaymentRepositoryImpl(paymentRepository);
    }
}
