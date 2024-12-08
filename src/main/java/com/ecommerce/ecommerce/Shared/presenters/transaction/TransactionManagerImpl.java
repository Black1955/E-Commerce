package com.ecommerce.ecommerce.Shared.presenters.transaction;

import com.ecommerce.ecommerce.Shared.core.transaction.Transaction;
import com.ecommerce.ecommerce.Shared.core.transaction.TransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionManagerImpl implements TransactionManager {

    @Override
    @Transactional
    public <R> R executeInTransaction(Transaction<R> transaction) {
        return transaction.run();
    }
}
