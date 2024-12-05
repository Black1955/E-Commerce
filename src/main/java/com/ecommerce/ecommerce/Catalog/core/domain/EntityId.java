package com.ecommerce.ecommerce.Catalog.core.domain;

public abstract class EntityId<T> {
    private final T value;
    public EntityId(T value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        EntityId<T> compared = (EntityId<T>) o;
        return compared.getValue() == this.getValue();
    }
    public T getValue() {
        return value;
    }
}
