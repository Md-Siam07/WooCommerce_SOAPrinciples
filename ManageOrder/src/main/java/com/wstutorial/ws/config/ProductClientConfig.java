package com.wstutorial.ws.config;

import com.wstutorial.ws.clients.ProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.wstutorial.ws.productservice", "com.wstutorial.ws.commonservice", "com.wstutorial.ws.orderservice", "com.wstutorial.ws.notificationservice");
        return marshaller;
    }

    @Bean
    public ProductClient productClient(Jaxb2Marshaller marshaller) {
        ProductClient client = new ProductClient();
        client.setDefaultUri("http://localhost:8084/ws/productService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
