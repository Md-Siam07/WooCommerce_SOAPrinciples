package com.wstutorial.ws.clients;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.notificationservice.CreateNotificationRequest;
import com.wstutorial.ws.notificationservice.GetNotificationsRequest;
import com.wstutorial.ws.notificationservice.GetNotificationsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class NotificationClient extends WebServiceGatewaySupport{
    public AcknowledgementCodeResponse createNotification(CreateNotificationRequest createNotificationRequest) {
        return (AcknowledgementCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(createNotificationRequest);
    }

    public GetNotificationsResponse getNotifications(GetNotificationsRequest getNotificationsRequest) {
        return (GetNotificationsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(getNotificationsRequest);
    }
}
