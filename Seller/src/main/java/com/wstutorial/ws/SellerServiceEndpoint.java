
package com.wstutorial.ws;

import java.util.List;


import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.sellerservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class SellerServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/SellerService";
	private SellerRepository sellerRepository = new SellerRepository();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createSellerRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse createSeller(@RequestPayload CreateSellerRequest request)throws Exception  {
		System.out.println("create seller called");

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		sellerRepository.createNewSeller(request.getSellerType());

		response.setAcknowledgementCode(AcknowledgementCode.CREATED);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateSellerRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateSeller(@RequestPayload UpdateSellerRequest request)throws Exception  {

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode updated = sellerRepository.updateSellerById(request.getSellerType().getId(), request.getSellerType());
		response.setAcknowledgementCode(updated);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteSellerRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse deleteSeller(@RequestPayload DeleteSellerRequest request)throws Exception  {
		System.out.println("-->deleteSeller<--");
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode ack = sellerRepository.deleteSellerById(request.getId());

		response.setAcknowledgementCode(ack);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSellersRequest" )
	@ResponsePayload
	public GetSellersResponse getSellers(@RequestPayload GetSellersRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetSellersResponse response = factory.createGetSellersResponse();

		List<Seller> sellers = sellerRepository.getSellers();

		response.getSellers().addAll(sellers);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSellerRequest" )
	@ResponsePayload
	public GetSellerResponse getSeller(@RequestPayload GetSellerRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetSellerResponse response = factory.createGetSellerResponse();

        Seller seller = sellerRepository.getSellerById(request.getId());
		response.setSeller(seller);
		return response;
	}




}