package org.productstar.mockito.repository;





import org.productstar.mockito.model.Customer;
import org.productstar.mockito.model.Delivery;
import org.productstar.mockito.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public Order create(Customer customer) {
        Order order = new Order(customer);
        order.setId(orders.size());
        orders.add(order);
        return order;
    }

    public Order addDelivery(int orderId, Delivery delivery) {
        Order order = orders.get(orderId);
        order.addDelivery(delivery);
        return order;
    }

    public List<Order> all() {
        return orders;
    }

    public int size() {
        return orders.size();
    }
}