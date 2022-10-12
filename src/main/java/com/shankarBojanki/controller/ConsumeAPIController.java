package com.shankarBojanki.controller;


import com.shankarBojanki.ApiEntity.Employees;
import com.shankarBojanki.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeAPIController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public ConsumeAPIController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }


//    @GetMapping("/getapidata")
//    public ResponseEntity<Employees> getData(){
//      return  new ResponseEntity<>(serviceLayer.ConsumeAPI(), HttpStatus.OK);
//    }



    @GetMapping("/getapidata")
    public  String getData(){
        return  serviceLayer.ConsumeAPI();
    }



}
