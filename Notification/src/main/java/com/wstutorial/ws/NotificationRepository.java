package com.wstutorial.ws;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.notificationservice.Notification;
import com.wstutorial.ws.notificationservice.NotificationStatus;

import java.util.ArrayList;
import java.util.List;

public class NotificationRepository {

    List<Notification> notifications = new ArrayList<>();

    public NotificationRepository() {
    }
    public List<Notification> getNotifications(Long userId) {
        List<Notification> selectedaNotifications = new ArrayList<>();
        for(Notification notification: notifications) {
            if(notification.getTo() == userId && notification.getStatus() == NotificationStatus.UNSEEN) {
                selectedaNotifications.add(notification);
            }
        }
        return selectedaNotifications;
    }

    public Notification getNotificationById(Long id) {
        for(Notification c: notifications) {
            if(c.getId() == id) {
                return c;
            }
        }
        System.out.println("can not delete: notification not found with id: " + id);
        return null;
    }

    public AcknowledgementCode deleteNotificationById(Long id) {

        for(Notification c: notifications) {
            if(c.getId() == id) {
                notifications.remove(c);
                return AcknowledgementCode.DELETED;
            }
        }
        System.out.println("can not delete: notification not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }

    public AcknowledgementCode updateNotificationById(Long id, Notification notification) {
        if (id == null || notification == null) {
            System.out.println("Invalid input: id or notification is null");
            return AcknowledgementCode.FAILED;
        }

        for (int i = 0; i < notifications.size(); i++) {
            Long notificationId = notifications.get(i).getId();
            if (notificationId.equals(id)) {
                notifications.set(i, notification);
                return AcknowledgementCode.UPDATED;
            }
        }
        System.out.println("Cannot update: notification not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }


    public void createNewNotification(Notification notification) {
        notification.setId(notifications.size()+1);
        notification.setStatus(NotificationStatus.UNSEEN);
        notifications.add(notification);
    }

    public void changeNotificationStatus(List<Notification> notifications) {
        for(Notification notification: this.notifications) {
            for(Notification n: notifications) {
                if(n.getId() == notification.getId()) {
                    notification.setStatus(NotificationStatus.SEEN);
                }
            }
        }
    }

}
