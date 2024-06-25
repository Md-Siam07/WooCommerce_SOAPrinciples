
package com.wstutorial.ws;

import java.util.List;


import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.commonservice.AcknowledgementCodeResponse;
import com.wstutorial.ws.notificationservice.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class NotificationServiceEndpoint {
	private static final String NAMESPACE_URI = "http://www.wstutorial.com/ws/NotificationService";
	private NotificationRepository notificationRepository = new NotificationRepository();

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createNotificationRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse createNotification(@RequestPayload CreateNotificationRequest request)throws Exception  {
		System.out.println("create notification called");

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		notificationRepository.createNewNotification(request.getNotificationType());

		response.setAcknowledgementCode(AcknowledgementCode.CREATED);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateNotificationRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse updateNotification(@RequestPayload UpdateNotificationRequest request)throws Exception  {

		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode updated = notificationRepository.updateNotificationById(request.getNotificationType().getId(), request.getNotificationType());
		response.setAcknowledgementCode(updated);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteNotificationRequest" )
	@ResponsePayload
	public AcknowledgementCodeResponse deleteNotification(@RequestPayload DeleteNotificationRequest request)throws Exception  {
		System.out.println("-->deleteNotification<--");
		AcknowledgementCodeResponse response = new AcknowledgementCodeResponse();

		AcknowledgementCode ack = notificationRepository.deleteNotificationById(request.getId());

		response.setAcknowledgementCode(ack);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNotificationsRequest" )
	@ResponsePayload
	public GetNotificationsResponse getNotifications(@RequestPayload GetNotificationsRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetNotificationsResponse response = factory.createGetNotificationsResponse();

		List<Notification> notifications = notificationRepository.getNotifications(request.getUserId());

		response.getNotifications().addAll(notifications);
        notificationRepository.changeNotificationStatus(notifications);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNotificationRequest" )
	@ResponsePayload
	public GetNotificationResponse getNotification(@RequestPayload GetNotificationRequest request)throws Exception  {
		ObjectFactory factory = new ObjectFactory();
		GetNotificationResponse response = factory.createGetNotificationResponse();

        Notification notification = notificationRepository.getNotificationById(request.getId());
		response.setNotification(notification);
		return response;
	}




}