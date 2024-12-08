package com.ecommerce.ecommerce.Shared.core.transaction;

public interface TransactionManager {
     <R> R executeInTransaction(Transaction<R> transaction);
}
