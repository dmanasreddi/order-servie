package com.order.manage.mapper;

import java.util.List;
import java.util.UUID;
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
public class OrdersEntityMapper {

	public OrdersEntity modelToOrdersEntity(OrdersModel ordersModel) {
		ordersModel.setOrderId(getId(ordersModel.getOrderId()));
		OrdersEntity ordersEntity = new OrdersEntity();
		BeanUtils.copyProperties(ordersModel, ordersEntity);
		ordersEntity.setOrderItemList(modelToOrderItemEntities(ordersModel.getOrderItemModelList(),ordersEntity));
		ordersEntity.setOrderStatusEntity(modelToOrderStatusEntity(ordersModel.getOrderStatusModel()));
		ordersEntity.setPaymentStatusEntity(modelToPaymentStatusEntity(ordersModel.getPaymentStatusModel()));
		ordersEntity.setShipementStatus(modelToShipmentStatusEntity(ordersModel.getShipementStatusModel()));
		return ordersEntity;
	}

	public OrderItemEntity modelToOrderItemEntity(OrderItemModel OrderItemModel, OrdersEntity ordersEntity) {
		OrderItemModel.setOrderItemId(getId(OrderItemModel.getOrderItemId()));
		OrderItemEntity orderItemEntity = new OrderItemEntity();
		BeanUtils.copyProperties(OrderItemModel, orderItemEntity);
		return orderItemEntity;
	}

	public List<OrderItemEntity> modelToOrderItemEntities(List<OrderItemModel> orderItemModels,OrdersEntity ordersEntity) {
		return orderItemModels.stream().map(orderItems -> modelToOrderItemEntity(orderItems,ordersEntity))
				.collect(Collectors.toList());
	}

	public OrderStatusEntity modelToOrderStatusEntity(OrderStatusModel orderStatusModel) {
		orderStatusModel.setOrderStatusId(getId(orderStatusModel.getOrderStatusId()));
		OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
		BeanUtils.copyProperties(orderStatusModel, orderStatusEntity);
		return orderStatusEntity;
	}

	public PaymentStatusEntity modelToPaymentStatusEntity(PaymentStatusModel paymentStatusModel) {
		paymentStatusModel.setPaymentStatusId(getId(paymentStatusModel.getPaymentStatusId()));
		PaymentStatusEntity paymentStatusEntity = new PaymentStatusEntity();
		BeanUtils.copyProperties(paymentStatusModel, paymentStatusEntity);
		return paymentStatusEntity;
	}

	public ShipmentStatusEntity modelToShipmentStatusEntity(ShipmentStatusModel shipmentStatusModel) {
		shipmentStatusModel.setShipmentStatusId(getId(shipmentStatusModel.getShipmentStatusId()));
		ShipmentStatusEntity shipmentStatusEntity = new ShipmentStatusEntity();
		BeanUtils.copyProperties(shipmentStatusModel, shipmentStatusEntity);
		return shipmentStatusEntity;
	}

	public int getId(int id) {
		if (id >= 0) {
			id = UUID.randomUUID().hashCode();
		}
		return id;
	}
}
