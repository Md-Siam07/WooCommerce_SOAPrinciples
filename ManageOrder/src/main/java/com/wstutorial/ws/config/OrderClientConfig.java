package com.wstutorial.ws.config;

import com.wstutorial.ws.clients.OrderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrderClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.wstutorial.ws.orderservice", "com.wstutorial.ws.commonservice", "com.wstutorial.ws.productervice", "com.wstutorial.ws.notificationservice");
        return marshaller;
    }

    @Bean
    public OrderClient orderClient(Jaxb2Marshaller marshaller) {
        OrderClient client = new OrderClient();
        client.setDefaultUri("http://localhost:8087/ws/orderService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
