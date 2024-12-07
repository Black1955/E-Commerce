package com.ecommerce.ecommerce.Order.core.usecases;

import com.ecommerce.ecommerce.Order.core.domain.Order.Order;
import com.ecommerce.ecommerce.Order.core.domain.Order.UserId;
import com.ecommerce.ecommerce.Order.core.repositories.OrderRepository;
import com.ecommerce.ecommerce.Shared.Page;

/**
 * The FindOrderByStatus class provides methods to retrieve orders based on their status,
 * with optional filters for page size, page number, and user ID. The class interacts with
 * the OrderRepository to fetch order records from the underlying data store.
 */
public class FindOrderByStatus {
    private final OrderRepository orderRepository;

    public static int DEFAULT_SIZE = 10;
    public static int DEFAULT_PAGE = 0;

    /**
     * Constructs a new instance of FindOrderByStatus.
     *
     * @param orderRepository the repository used to fetch orders from the database.
     */
    public FindOrderByStatus(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Retrieves orders by their status with default page size and page number.
     *
     * @param status the status of the orders to be fetched.
     * @return a Page containing the orders with the specified status.
     */
    public Page<Order> execute(Order.Status status) {
        return execute(status, DEFAULT_SIZE, DEFAULT_PAGE, null);
    }

    /**
     * Retrieves orders by their status with custom page size and page number, without filtering by user ID.
     *
     * @param status the status of the orders to be fetched.
     * @param size   the number of orders per page.
     * @param page   the page number to retrieve.
     * @return a Page containing the orders with the specified status.
     * @throws IllegalArgumentException if size is less than or equal to 0, or if page is less than 0.
     */
    public Page<Order> execute(Order.Status status, int size, int page) {
        validatePageAndSize(size, page);
        return execute(status, size, page, null);
    }

    /**
     * Retrieves orders by their status for a specific user with default page size and page number.
     *
     * @param status the status of the orders to be fetched.
     * @param userId the user ID whose orders are to be fetched.
     * @return a Page containing the orders with the specified status for the given user.
     */
    public Page<Order> execute(Order.Status status, UserId userId) {
        return execute(status, DEFAULT_SIZE, DEFAULT_PAGE, userId);
    }

    /**
     * Retrieves orders by their status with custom page size, page number, and user ID filter.
     *
     * @param status the status of the orders to be fetched.
     * @param size   the number of orders per page.
     * @param page   the page number to retrieve.
     * @param userId the user ID whose orders are to be fetched.
     * @return a Page containing the orders with the specified status for the given user.
     * @throws IllegalArgumentException if size is less than or equal to 0, or if page is less than 0.
     */
    public Page<Order> execute(Order.Status status, int size, int page, UserId userId) {
        validatePageAndSize(size, page);
        return this.orderRepository.findByStatus(status, size, page, userId);
    }

    /**
     * Validates the provided page and size parameters to ensure they are valid.
     *
     * @param size the number of orders per page.
     * @param page the page number to retrieve.
     * @throws IllegalArgumentException if size is less than or equal to 0, or if page is less than 0.
     */
    private void validatePageAndSize(int size, int page) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        if (page < 0) {
            throw new IllegalArgumentException("Page must be 0 or greater.");
        }
    }
}
