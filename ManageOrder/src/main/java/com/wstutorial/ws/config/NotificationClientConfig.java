package com.wstutorial.ws.config;

import com.wstutorial.ws.clients.NotificationClient;
import com.wstutorial.ws.clients.ProductClient;
import com.wstutorial.ws.notificationservice.CreateNotificationRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class NotificationClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.wstutorial.ws.notificationservice", "com.wstutorial.ws.commonservice", "com.wstutorial.ws.orderservice");
//        marshaller.setContextPath("com.wstutorial.ws.notificationservice");
//        marshaller.setClassesToBeBound(CreateNotificationRequest.class);
        return marshaller;
    }

    @Bean
    public NotificationClient notificationClient(Jaxb2Marshaller marshaller) {
        NotificationClient client = new NotificationClient();
        client.setDefaultUri("http://localhost:8085/ws/notificationService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
