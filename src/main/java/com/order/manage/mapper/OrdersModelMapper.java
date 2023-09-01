package com.order.manage.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.order.manage.entity.OrderItemEntity;
import com.order.manage.entity.OrderStatusEntity;
import com.order.manage.entity.OrdersEntity;
import com.order.manage.entity.PaymentStatusEntity;
import com.order.manage.entity.ShipmentStatusEntity;
import com.order.manage.model.OrderItemModel;
import com.order.manage.model.OrderStatusModel;
import com.order.manage.model.OrdersModel;
import com.order.manage.model.PaymentStatusModel;
import com.order.manage.model.ShipmentStatusModel;

@Component
public class OrdersModelMapper {

	public OrdersModel entityToOrdersModel(OrdersEntity ordersEntity) {
		OrdersModel ordersModel = new OrdersModel();
		BeanUtils.copyProperties(ordersEntity, ordersModel);
		ordersModel.setOrderItemModelList(entitiesToOrderItemModels(ordersEntity.getOrderItemList()));
		ordersModel.setOrderStatusModel(entityToOrderStatusModel(ordersEntity.getOrderStatusEntity()));
		ordersModel.setPaymentStatusModel(entityTopaymePaymentStatusModel(ordersEntity.getPaymentStatusEntity()));
		ordersModel.setShipementStatusModel(entityToShipmentStatusModel(ordersEntity.getShipementStatus()));
		return ordersModel;
	}

	public OrderStatusModel entityToOrderStatusModel(OrderStatusEntity orderStatusEntity) {
		OrderStatusModel orderStatusModel = new OrderStatusModel();
		BeanUtils.copyProperties(orderStatusEntity, orderStatusModel);
		return orderStatusModel;
	}

	public PaymentStatusModel entityTopaymePaymentStatusModel(PaymentStatusEntity paymentStatusEntity) {
		PaymentStatusModel paymentStatusModel = new PaymentStatusModel();
		BeanUtils.copyProperties(paymentStatusEntity, paymentStatusModel);
		return paymentStatusModel;
	}

	public ShipmentStatusModel entityToShipmentStatusModel(ShipmentStatusEntity shipmentStatusEntity) {
		ShipmentStatusModel shipmentStatusModel = new ShipmentStatusModel();
		BeanUtils.copyProperties(shipmentStatusEntity, shipmentStatusModel);
		return shipmentStatusModel;
	}

	public OrderItemModel entityToOrderItemModel(OrderItemEntity orderItemEntity) {
		OrderItemModel orderItemModel = new OrderItemModel();
		BeanUtils.copyProperties(orderItemEntity, orderItemModel);
		return orderItemModel;
	}

	public List<OrderItemModel> entitiesToOrderItemModels(List<OrderItemEntity> OrderItemEntities) {
		return OrderItemEntities.stream().map(OrderItems -> entityToOrderItemModel(OrderItems))
				.collect(Collectors.toList());
	}
}
