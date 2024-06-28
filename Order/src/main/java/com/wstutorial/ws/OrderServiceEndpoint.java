
package com.wstutorial.ws;

import java.util.List;


import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.orderservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class OrderServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/OrderService";
	private OrderRepository orderRepository = new OrderRepository();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse createOrder(@RequestPayload CreateOrderRequest request)throws Exception  {
		System.out.println("create order called");

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		orderRepository.createNewOrder(request.getOrderType());

		response.setAcknowledgementCode(AcknowledgementCode.CREATED);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateOrderRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateOrder(@RequestPayload UpdateOrderRequest request)throws Exception  {

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode updated = orderRepository.updateOrderById(request.getOrderType().getId(), request.getOrderType());
		response.setAcknowledgementCode(updated);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteOrderRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse deleteOrder(@RequestPayload DeleteOrderRequest request)throws Exception  {
		System.out.println("-->deleteOrder<--");
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode ack = orderRepository.deleteOrderById(request.getId());

		response.setAcknowledgementCode(ack);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrdersRequest" )
	@ResponsePayload
	public GetOrdersResponse getOrders(@RequestPayload GetOrdersRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetOrdersResponse response = factory.createGetOrdersResponse();

		List<Order> orders = orderRepository.getOrders();

		response.getOrders().addAll(orders);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderRequest" )
	@ResponsePayload
	public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetOrderResponse response = factory.createGetOrderResponse();

        Order order = orderRepository.getOrderById(request.getId());
		response.setOrder(order);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrdersBySellerIdRequest" )
	@ResponsePayload
	public GetOrdersResponse getOrdersBySellerId(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetOrdersResponse response = factory.createGetOrdersResponse();

		List<Order> orders = orderRepository.getOrdersBySellerId(request.getSellerId());
		response.getOrders().addAll(orders);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPendingOrdersBySellerIdRequest" )
	@ResponsePayload
	public GetOrdersResponse getPendingOrdersBySellerIdRequest(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetOrdersResponse response = factory.createGetOrdersResponse();

		List<Order> orders = orderRepository.getAllPendingOrdersBySellerId(request.getSellerId());
		response.getOrders().addAll(orders);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateOrderStatusRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateOrderStatus(@RequestPayload UpdateOrderStatusRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		orderRepository.changeOrderStatus(request.getId(), request.getStatus());
		response.setAcknowledgementCode(AcknowledgementCode.UPDATED);
		return response;
	}

}