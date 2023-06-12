package com.fibe.Fibe.controlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fibe.Fibe.data.request.Credential;
import com.fibe.Fibe.data.request.Lead;
import com.fibe.Fibe.services.Services;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Log4j2
public class Controller {
    ObjectMapper objectMapper;
    private Services services;
    @Autowired
    public ObjectMapper seObjectMapper(ObjectMapper objectMapper){
        return this.objectMapper=objectMapper;
    }
    @Autowired
    public Services setServices(Services services){
        return this.services=services;
    }
    @PostMapping("/")
    public ObjectNode getToken(@RequestBody Credential credential){
         return services.getToken(credential);
    }
    @PostMapping("/lead-post")
    public  ObjectNode leadPost(@RequestBody @Valid Lead lead){
        return services.leadPost(lead);
    }
    @PostMapping("/customer-status")
    public  ObjectNode customerStatus( @RequestBody ObjectNode objectNode){
       if( objectNode.has("customerID")){
           return  services.customerStatus("customerId",objectNode.get("customerId").toString());
        }
        if( objectNode.has("custRefNo")){
            return  services.customerStatus("custRefNo",objectNode.get("custRefNo").toString());
        }





        log.info("fldfdfdgfgdfgdfhghjghfghghhtrjtyjtjgrjtutyhrgtrhtyhtrhtyjtyrghtyjtyjjhryjtyjhtrhtrhtrhtrhr");
        return  objectMapper.createObjectNode();
    }
}
