package com.shankarBojanki.service;


import com.shankarBojanki.ApiEntity.Employees;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class ServiceLayer {


    private final RestTemplate restTemplate;

    public ServiceLayer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }






//    public Employees ConsumeAPI(){
//        return restTemplate.getForObject(
//                "https://api.mockaroo.com/api/dcf6b820?count=1000&key=b482f1f0",
//                Employees.class);
//    }







    // @S*-M*-H*-D*-M*-W*
    //every 10 seconds
    @Scheduled(cron = "*/10 * * * * *")
    public String ConsumeAPI(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("every 10 seconds "+localDateTime);
        return restTemplate.getForObject(
                "https://api.mockaroo.com/api/dcf6b820?count=1000&key=b482f1f0",
                String.class);
    }





}
