package com.wstutorial.ws.clients;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.orderservice.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OrderClient extends WebServiceGatewaySupport {

    public AcknowledgementCodeResponse createOrder(CreateOrderRequest createOrderRequest) {

        return (AcknowledgementCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(createOrderRequest);
    }

    public GetOrderResponse getOrderById(GetOrderRequest getOrderRequest) {
        return (GetOrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive(getOrderRequest);
    }

    public GetOrdersResponse getOrdersBySellerId(GetOrdersBySellerIdRequest getOrdersBySellerIdRequest) {
        return (GetOrdersResponse) getWebServiceTemplate()
                .marshalSendAndReceive(getOrdersBySellerIdRequest);
    }

    public AcknowledgementCodeResponse changeOrderStatus(UpdateOrderStatusRequest updateOrderStatusRequest) {
        return (AcknowledgementCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(updateOrderStatusRequest);
    }
}
