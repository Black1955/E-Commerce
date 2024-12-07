package com.ecommerce.ecommerce.Order.data.mappers;

import com.ecommerce.ecommerce.Order.core.domain.Order.Adress;
import com.ecommerce.ecommerce.Order.data.entities.AdressEmbeddable;

public class AdressMapper {
    public static AdressEmbeddable toEmbeddable(Adress adress) {
        return new AdressEmbeddable(
                adress.getStreet(),
                adress.getCity(),
                adress.getZIP(),
                adress.getCountry()
        );
    }

    public static Adress toDomain(AdressEmbeddable embeddable) {
        return new Adress(
                embeddable.getStreet(),
                embeddable.getCity(),
                embeddable.getZIP(),
                embeddable.getCountry()
        );
    }
}

