package com.ecommerce.ecommerce.Shared.core.transaction;

@FunctionalInterface
public interface Transaction<R> {
    R run();
}
