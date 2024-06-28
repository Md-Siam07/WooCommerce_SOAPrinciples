
package com.wstutorial.ws;

import java.util.List;


import com.wstutorial.ws.clients.NotificationClient;
import com.wstutorial.ws.clients.OrderClient;
import com.wstutorial.ws.clients.ProductClient;
import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.manageorderservice.ManageOrderType;
import com.wstutorial.ws.notificationservice.CreateNotificationRequest;
import com.wstutorial.ws.notificationservice.Notification;
import com.wstutorial.ws.orderservice.*;
import com.wstutorial.ws.productservice.Product;
import com.wstutorial.ws.productservice.Products;
import com.wstutorial.ws.productservice.UpdateProductStockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ManageOrderServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/ManageOrderService";
	@Autowired
	private OrderClient orderClient;

	@Autowired
	private ProductClient productClient;

	@Autowired
	private NotificationClient notificationClient;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateManageOrder" )
	@ResponsePayload
	public AcknowledgementCodeResponse createManageOrders(@RequestPayload ManageOrderType request)throws Exception  {
		System.out.println("create order called");

		CreateOrderRequest createOrderRequest = new CreateOrderRequest();
		createOrderRequest.setOrderType(request.getOrder());

		CreateNotificationRequest notificationRequest = new CreateNotificationRequest();

		Notification notification = new Notification();
		notification.setFrom(request.getOrder().getCustomerId());
		notification.setTo(request.getOrder().getSellerId());
		notification.setContent("Your have received an order!");
		notificationRequest.setNotificationType(notification);
		AcknowledgementCodeResponse acknowledgementCode = notificationClient.createNotification(notificationRequest);


		AcknowledgementCodeResponse response = orderClient.createOrder(createOrderRequest);
        System.out.println(request.getOrder().getId());

		return response;
	}

	@PayloadRoot(namespace = "http://www.wstutorial.com/ws/OrderService", localPart = "updateOrderStatusRequest")
	@ResponsePayload
	public AcknowledgementCodeResponse updateOrderStatusRequest(@RequestPayload UpdateOrderStatusRequest request)throws Exception  {
		try{
//			System.out.println("update order status called");
			if(request.getStatus() == OrderStatus.CONFIRMED) {
				GetOrderRequest getOrderRequest = new GetOrderRequest();
				getOrderRequest.setId(request.getId());
				System.out.println(getOrderRequest.getId());
				GetOrderResponse order = orderClient.getOrderById(getOrderRequest);
				System.out.println("sh: "+order.getOrder().getId());
				AcknowledgementCodeResponse failure = new AcknowledgementCodeResponse();
				failure.setAcknowledgementCode(AcknowledgementCode.FAILED);

				if(order != null) {
					List<Order.Products> products = order.getOrder().getProducts();
					for(Order.Products product: products) {
						List<ProductItem> productItems = product.getProduct();

						//since the retailer has confirmed the order, we need to update the stock
						for(ProductItem productItem: productItems) {
							UpdateProductStockRequest updateProductStockRequest = new UpdateProductStockRequest();
							updateProductStockRequest.setId(productItem.getProductHeader().getId());
							updateProductStockRequest.setQuantity(productItem.getQuantity());
							AcknowledgementCodeResponse acknowledgementCodeResponse = productClient.updateProductStock(updateProductStockRequest);
							if(acknowledgementCodeResponse.getAcknowledgementCode() == AcknowledgementCode.FAILED) {
								return failure;
							}
						}

					}
				}

				else return failure;

				CreateNotificationRequest notificationRequest = new CreateNotificationRequest();

				Notification notification = new Notification();
				notification.setFrom(order.getOrder().getSellerId());
				notification.setTo(order.getOrder().getCustomerId());

				notification.setContent("Your order has been confirmed!");
				notificationRequest.setNotificationType(notification);
				AcknowledgementCodeResponse acknowledgementCode = notificationClient.createNotification(notificationRequest);

			}

			return orderClient.changeOrderStatus(request);
		}catch (Exception e) {
			System.err.println("Error in updateOrderStatusRequest: " + e.getMessage());
			e.printStackTrace();
			throw e; //
		}
	}


	@PayloadRoot(namespace = "http://www.wstutorial.com/ws/OrderService", localPart = "getOrdersBySellerIdRequest")
	@ResponsePayload
	public GetOrdersResponse getOrdersBySellerIdRequest(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
		System.out.println("get orders by seller id called");

        return orderClient.getOrdersBySellerId(request);
	}

//	@PayloadRoot(namespace = "http://www.wstutorial.com/ws/NotificationService", localPart = "manageCreateNotification")
//	@ResponsePayload
//	public GetOrdersResponse manageCreateNotification(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
//		System.out.println("get orders by seller id called");
//
//		return orderClient.getOrdersBySellerId(request);
//	}
//
//	@PayloadRoot(namespace = "http://www.wstutorial.com/ws/NotificationService", localPart = "manageGetNotification")
//	@ResponsePayload
//	public GetOrdersResponse manageGetNotification(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
//		System.out.println("get orders by seller id called");
//
//		return orderClient.getOrdersBySellerId(request);
//	}
//
//
//	@PayloadRoot(namespace = "http://www.wstutorial.com/ws/ProductService", localPart = "manageUpdateProductStock")
//	@ResponsePayload
//	public GetOrdersResponse manageUpdateProductStock(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
//		System.out.println("get orders by seller id called");
//
//		return orderClient.getOrdersBySellerId(request);
//	}
//
//	@PayloadRoot(namespace = "http://www.wstutorial.com/ws/LogService", localPart = "manageCreateLog")
//	@ResponsePayload
//	public GetOrdersResponse manageCreateLog(@RequestPayload GetOrdersBySellerIdRequest request)throws Exception  {
//		System.out.println("get orders by seller id called");
//
//		return orderClient.getOrdersBySellerId(request);
//	}
}