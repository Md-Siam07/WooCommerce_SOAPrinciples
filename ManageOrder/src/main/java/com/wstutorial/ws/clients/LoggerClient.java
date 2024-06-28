package com.wstutorial.ws.clients;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.logservice.LogsRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LoggerClient extends WebServiceGatewaySupport{
    public AcknowledgementCodeResponse createLog(LogsRequest logsRequest) {
        return (AcknowledgementCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(logsRequest);
    }
}
