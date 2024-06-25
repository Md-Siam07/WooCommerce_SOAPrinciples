
package com.wstutorial.ws;

import java.util.List;


import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.productservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ProductServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/ProductService";
	private ProductRepository productRepository = new ProductRepository();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse createProduct(@RequestPayload CreateProductRequest request)throws Exception  {
		System.out.println("create product called");

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		productRepository.createNewProduct(request.getProductType());

		response.setAcknowledgementCode(AcknowledgementCode.CREATED);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateProduct(@RequestPayload UpdateProductRequest request)throws Exception  {

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode updated = productRepository.updateProductById(request.getProductType().getId(), request.getProductType());
		response.setAcknowledgementCode(updated);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse deleteProduct(@RequestPayload DeleteProductRequest request)throws Exception  {
		System.out.println("-->deleteProduct<--");
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode ack = productRepository.deleteProductById(request.getId());

		response.setAcknowledgementCode(ack);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest" )
	@ResponsePayload
	public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetProductsResponse response = factory.createGetProductsResponse();

		List<Product> products = productRepository.getProducts();

		response.getProducts().addAll(products);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest" )
	@ResponsePayload
	public GetProductResponse getProduct(@RequestPayload GetProductRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetProductResponse response = factory.createGetProductResponse();

        Product product = productRepository.getProductById(request.getId());
		response.setProduct(product);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsBySellerIdRequest" )
	@ResponsePayload
	public GetProductsResponse getProductsBySellerId(@RequestPayload GetProductsBySellerIdRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetProductsResponse response = factory.createGetProductsResponse();

		List<Product> products = productRepository.getProductsBySellerId(request.getSellerId());
		response.getProducts().addAll(products);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductStockRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateProductStockRequest(@RequestPayload UpdateProductStockRequest request)throws Exception  {
		System.out.println("-->deleteProduct<--");
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode ack = productRepository.updateProductStock(request.getId(), request.getQuantity());

		response.setAcknowledgementCode(ack);

		return response;
	}

}