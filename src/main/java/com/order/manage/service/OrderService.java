package com.order.manage.service;

import com.order.manage.model.OrdersModel;

public interface OrderService {

	public void createOrder(OrdersModel ordersModel);

	public void updateOrder(OrdersModel ordersModel);

	public void deleteByOrderId(int orderId);

	public OrdersModel findByOrderId(int orderId);
}
