
package com.wstutorial.ws;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.logservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.swing.*;


@Endpoint
public class LogServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/LogService";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "logsRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse createLog(@RequestPayload LogsRequest request)throws Exception  {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		System.out.println(dtf.format(now) + "------------ " + request.getContent() + " ------------");

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();
		response.setAcknowledgementCode(AcknowledgementCode.CREATED);
		return response;
	}
}