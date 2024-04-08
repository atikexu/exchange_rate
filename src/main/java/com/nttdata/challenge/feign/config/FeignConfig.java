//package com.nttdata.challenge.feign.config;
//
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.boot.web.client.RestTemplateCustomizer;
//import org.springframework.cloud.openfeign.FeignClientsConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import com.nttdata.challenge.feign.ExchangeRateFeign;
//
//@Configuration
//public class FeignConfig extends FeignClientsConfiguration {
//
//	@Bean
//    public RestTemplateCustomizer restTemplateCustomizer() {
//        return restTemplate -> {
//            try {
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, new TrustManager[]{new X509TrustManager() {
//                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                        return null;
//                    }
//                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
//                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
//                }}, new SecureRandom());
//                restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // Constructor sin argumentos
//            } catch (NoSuchAlgorithmException | KeyManagementException e) {
//                throw new RuntimeException("Error creating custom TrustManager", e);
//            }
//        };
//    }
//}
