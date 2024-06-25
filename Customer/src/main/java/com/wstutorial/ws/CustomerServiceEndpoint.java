
package com.wstutorial.ws;

import java.util.ArrayList;
import java.util.List;


import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.customerservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CustomerServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/CustomerService";
	private CustomerRepository customerRepository = new CustomerRepository();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCustomerRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse createCustomer(@RequestPayload CreateCustomerRequest request)throws Exception  {
		System.out.println("create customer called");

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		customerRepository.createNewCustomer(request.getCustomerType());

		response.setAcknowledgementCode(AcknowledgementCode.CREATED);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCustomerRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateCustomer(@RequestPayload UpdateCustomerRequest request)throws Exception  {

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode updated = customerRepository.updateCustomerById(request.getCustomerType().getId(), request.getCustomerType());
		response.setAcknowledgementCode(updated);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCustomerRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request)throws Exception  {
		System.out.println("-->deleteCustomer<--");
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode ack = customerRepository.deleteCustomerById(request.getId());

		response.setAcknowledgementCode(ack);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomersRequest" )
	@ResponsePayload
	public GetCustomersResponse getCustomers(@RequestPayload GetCustomersRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetCustomersResponse response = factory.createGetCustomersResponse();

		List<Customer> customers = customerRepository.getCustomers();

		response.getCustomers().addAll(customers);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest" )
	@ResponsePayload
	public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetCustomerResponse response = factory.createGetCustomerResponse();

        Customer customer = customerRepository.getCustomerById(request.getId());
		response.setCustomer(customer);
		return response;
	}




}