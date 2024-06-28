package com.wstutorial.ws.config;

import com.wstutorial.ws.clients.LoggerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class LoggerClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.wstutorial.ws.logservice", "com.wstutorial.ws.commonservice");
        return marshaller;
    }

    @Bean
    public LoggerClient loggerClient(Jaxb2Marshaller marshaller) {
        LoggerClient client = new LoggerClient();
        client.setDefaultUri("http://localhost:8086/ws/logService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
