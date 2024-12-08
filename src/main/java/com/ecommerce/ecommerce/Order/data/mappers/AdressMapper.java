package com.ecommerce.ecommerce.Order.data.mappers;

import com.ecommerce.ecommerce.Order.core.domain.Order.Adress;
import com.ecommerce.ecommerce.Order.data.entities.AdressEmbeddable;

public class AdressMapper {
    public static AdressEmbeddable toEmbeddable(Adress adress) {
        return new AdressEmbeddable(
                adress.getCountry(),
                adress.getCity(),
                adress.getZIP(),
                adress.getStreet()
        );
    }

    public static Adress toDomain(AdressEmbeddable embeddable) {
        return new Adress(
                embeddable.getCountry(),
                embeddable.getCity(),
                embeddable.getZIP(),
                embeddable.getStreet()
        );
    }
}

