package com.ecommerce.ecommerce.Payment.data.mappers;

import com.ecommerce.ecommerce.Payment.core.domain.OrderId;
import com.ecommerce.ecommerce.Payment.core.domain.Payer.Payer;
import com.ecommerce.ecommerce.Payment.core.domain.Payment;
import com.ecommerce.ecommerce.Payment.core.domain.PaymentId;
import com.ecommerce.ecommerce.Payment.core.domain.Price;
import com.ecommerce.ecommerce.Payment.data.entities.PayerEmbeddable;
import com.ecommerce.ecommerce.Payment.data.entities.PaymentEntity;

public class PaymentMapper {
    public static Payment toDomain(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Payment(
                entity.getId() != null ? new PaymentId(entity.getId()) : null,
                new Price(entity.getPrice()),
                toDomainPayer(entity.getPayer()),
                new OrderId(entity.getOrderId()),
                entity.getCreatedAt(),
                Payment.PaymentStatus.valueOf(entity.getStatus().toString())
        );
    }

    public static PaymentEntity toEntity(Payment domain) {
        if (domain == null) {
            return null;
        }

        return new PaymentEntity(
                domain.getId() != null ? domain.getId().getValue() : null,
                domain.getPrice().getValue(),
                toEntityPayer(domain.getPayer()),
                domain.getOrderId().getValue(),
                domain.getCreatedAt(),
                PaymentEntity.PaymentStatus.valueOf(domain.getStatus().toString())
        );
    }

    private static Payer toDomainPayer(PayerEmbeddable embeddable) {
        if (embeddable == null) {
            return null;
        }

        return new Payer(
                new com.ecommerce.ecommerce.Payment.core.domain.Payer.UserId(embeddable.getUserId()),
                new com.ecommerce.ecommerce.Payment.core.domain.Payer.PaymentDetails(
                        embeddable.getPaymentDetails().getCardNumber(),
                        embeddable.getPaymentDetails().getCVV(),
                        embeddable.getPaymentDetails().getExpirationDate()
                )
        );
    }

    private static PayerEmbeddable toEntityPayer(Payer payer) {
        if (payer == null) {
            return null;
        }

        return new PayerEmbeddable(
                payer.getUserId().getValue(),
                new com.ecommerce.ecommerce.Payment.data.entities.PaymentDetailsEmbeddable(
                        payer.getPaymentDetails().getCardNumber(),
                        payer.getPaymentDetails().getCVV(),
                        payer.getPaymentDetails().getExpirationDate()
                )
        );
    }

}
