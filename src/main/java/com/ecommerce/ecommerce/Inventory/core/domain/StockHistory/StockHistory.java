package com.ecommerce.ecommerce.Inventory.core.domain.StockHistory;

import com.ecommerce.ecommerce.Inventory.core.domain.OrderId;
import com.ecommerce.ecommerce.Inventory.core.domain.ProductId;
import com.ecommerce.ecommerce.Inventory.core.domain.Quantity;

import java.time.LocalDateTime;

/**
 * Represents a history record of stock changes for a specific product.
 *
 * <p>This entity is designed to track all changes made to the stock of a product,
 * providing detailed information about the type and reason for each change.
 * It is useful for auditing stock movements, analyzing trends, and debugging issues
 * related to inventory management.</p>
 *
 * <h3>Key Responsibilities:</h3>
 * <ul>
 *   <li>Records changes to stock quantity, including additions and subtractions.</li>
 *   <li>Associates stock changes with specific reasons, such as order creation,
 *   order cancellation, restocking, or product returns.</li>
 *   <li>Stores timestamps for when each stock change occurs, allowing for chronological tracking.</li>
 * </ul>
 *
 * <h3>Fields:</h3>
 * <ul>
 *   <li><b>id:</b> Unique identifier for this stock history record.</li>
 *   <li><b>productId:</b> Identifier for the product whose stock is being updated.</li>
 *   <li><b>changeType:</b> Type of change (e.g., ADD or SUBTRACT).</li>
 *   <li><b>changeAmount:</b> The quantity of the stock change.</li>
 *   <li><b>reason:</b> The reason for the stock change (e.g., order creation, restocking).</li>
 *   <li><b>timestamp:</b> The date and time when the stock change was recorded.</li>
 * </ul>
 *
 * <h3>Usage:</h3>
 * <p>Use this entity in systems that manage inventory to maintain a detailed log
 * of all stock movements. It can support the following scenarios:</p>
 * <ul>
 *   <li>Tracking stock reductions when orders are placed.</li>
 *   <li>Increasing stock when orders are cancelled or products are returned.</li>
 *   <li>Recording restocking events when new inventory is added.</li>
 *   <li>Providing historical data for audits or analytics.</li>
 * </ul>
 *
 * <h3>Enums:</h3>
 * <ul>
 *   <li><b>ChangeType:</b> Represents the type of stock change:
 *     <ul>
 *       <li><b>ADD:</b> Stock was added to inventory.</li>
 *       <li><b>SUBTRACT:</b> Stock was removed from inventory.</li>
 *     </ul>
 *   </li>
 *   <li><b>ReasonType:</b> Represents the reason for the stock change:
 *     <ul>
 *       <li><b>ORDER_CREATED:</b> Stock decrease due to the creation of an order.</li>
 *       <li><b>ORDER_CANCELLED:</b> Stock increase due to the cancellation of an order.</li>
 *       <li><b>RESTOCK:</b> Stock increase due to replenishment of inventory.</li>
 *       <li><b>RETURN:</b> Stock increase due to customer returns.</li>
 *     </ul>
 *   </li>
 * </ul>
 */

public class StockHistory {
    private StockHistoryId id;
    private ProductId productId;
    private OrderId orderId;
    private ChangeType changeType;
    private Quantity changeAmount;
    private ReasonType reason;
    private LocalDateTime timestamp;

    public StockHistory(StockHistoryId id, ProductId productId, ChangeType changeType, Quantity changeAmount, ReasonType reason, OrderId orderId) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.changeType = changeType;
        this.changeAmount = changeAmount;
        this.reason = reason;
        this.timestamp = LocalDateTime.now();
    }
    public static StockHistory createWithoutId(ProductId productId, ChangeType changeType, Quantity changeAmount, ReasonType reason, OrderId orderId) {
        return new StockHistory(null,productId,changeType,changeAmount,reason, orderId);
    }
    public enum ChangeType {
        ADD,
        SUBTRACT
    }
    public enum ReasonType {
        ORDER_CREATED, // Decrease due to order creation.
        ORDER_CANCELLED, // Increase due to order cancellation
        RESTOCK, // Increase due to stock replenishment.
        RETURN, // Increase due to customer returns.
    }


    public OrderId getOrderId() {
        return orderId;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Quantity getChangeAmount() {
        return changeAmount;
    }

    public ReasonType getReason() {
        return reason;
    }

    public StockHistoryId getId() {
        return id;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }
}
