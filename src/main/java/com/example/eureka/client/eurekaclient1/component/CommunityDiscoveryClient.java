package com.example.eureka.client.eurekaclient1.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommunityDiscoveryClient {

    private final RestTemplate restTemplate;

    public CommunityDiscoveryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
