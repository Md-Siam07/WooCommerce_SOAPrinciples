package com.wstutorial.ws;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.orderservice.*;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    List<Order> orders = new ArrayList<>();

    public OrderRepository() {}

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(Long id) {
        for(Order c: orders) {
            if(c.getId() == id) {
                return c;
            }
        }
        System.out.println("can not delete: order not found with id: " + id);
        return null;
    }

    public AcknowledgementCode deleteOrderById(Long id) {

        for(Order c: orders) {
            if(c.getId() == id) {
                orders.remove(c);
                return AcknowledgementCode.DELETED;
            }
        }
        System.out.println("can not delete: order not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }

    public AcknowledgementCode updateOrderById(Long id, Order order) {
        if (id == null || order == null) {
            System.out.println("Invalid input: id or order is null");
            return AcknowledgementCode.FAILED;
        }

        for (int i = 0; i < orders.size(); i++) {
            Long orderId = orders.get(i).getId();
            if (orderId.equals(id)) {
                orders.set(i, order);
                return AcknowledgementCode.UPDATED;
            }
        }
        System.out.println("Cannot update: order not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }


    public void createNewOrder(Order order) {
        order.setId(orders.size()+1);
        order.setStatus(OrderStatus.PENDING);
        orders.add(order);
    }

    public void changeOrderStatus(Long id, OrderStatus status) {
        for(Order order: orders) {
            if(order.getId() == id) {
                order.setStatus(status);
            }
        }
    }

    public List<Order> getAllPendingOrdersBySellerId(Long sellerId) {
        List<Order> prods = new ArrayList<>();
        for(Order order: orders) {
            if(order.getSellerId() == sellerId && order.getStatus() == OrderStatus.PENDING) {
                prods.add(order);
            }
        }
        return prods;
    }

    public List<Order> getOrdersBySellerId(Long id) {
        List<Order> prods = new ArrayList<>();
        for(Order order: orders) {
            if(order.getSellerId() == id) {
                prods.add(order);
            }
        }
        return prods;
    }

}
