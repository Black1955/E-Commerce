package com.ecommerce.ecommerce.Catalog.core.domain;


/**
 * value Object for Id`s
 * @param <T>
 */
public abstract class EntityId<T> {
    private final T value;
    public EntityId(T value) {
        if(value == null) {
            throw new IllegalArgumentException("id cannot be empty");
        }
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
