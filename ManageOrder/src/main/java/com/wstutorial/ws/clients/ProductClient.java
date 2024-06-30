package com.wstutorial.ws.clients;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.productservice.GetProductsRequest;
import com.wstutorial.ws.productservice.GetProductsResponse;
import com.wstutorial.ws.productservice.UpdateProductStockRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ProductClient extends WebServiceGatewaySupport{
    public AcknowledgementCodeResponse updateProductStock(UpdateProductStockRequest updateProductStockRequest) {
        return (AcknowledgementCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(updateProductStockRequest);
    }

    public GetProductsResponse getProducts(GetProductsRequest getProductsRequest) {
        return (GetProductsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(getProductsRequest);
    }
}
