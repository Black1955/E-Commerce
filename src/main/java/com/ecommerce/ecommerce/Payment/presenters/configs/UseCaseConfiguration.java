package com.ecommerce.ecommerce.Payment.presenters.configs;

import com.ecommerce.ecommerce.Payment.core.repositories.PaymentRepository;
import com.ecommerce.ecommerce.Payment.core.usecases.CreatePayment;
import com.ecommerce.ecommerce.Payment.core.usecases.GetPayment;
import com.ecommerce.ecommerce.Payment.core.usecases.UpdatePayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("PaymentUseCaseConfiguration")
public class UseCaseConfiguration {

    @Bean
    public CreatePayment createPayment(PaymentRepository paymentRepository) {
        return new CreatePayment(paymentRepository);
    }

    @Bean
    public GetPayment getPayment(PaymentRepository paymentRepository) {
        return new GetPayment(paymentRepository);
    }
    @Bean
    public UpdatePayment updatePayment(PaymentRepository paymentRepository) {
        return new UpdatePayment(paymentRepository);
    }
}
