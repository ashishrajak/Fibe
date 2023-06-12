package com.fibe.Fibe.services;

import com.fibe.Fibe.data.request.Credential;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fibe.Fibe.data.request.Lead;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
@Log4j2
public class Services {
    String token;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;
    @Autowired
    public ObjectMapper seObjectMapper(ObjectMapper objectMapper){
        return this.objectMapper=objectMapper;
    }
    @Autowired
    public  RestTemplate setRestTemplate(RestTemplate restTemplate){
        return this.restTemplate=restTemplate;
    }

    //generate token
    public  ObjectNode getToken(@Valid Credential credential){


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Credential> entity = new HttpEntity<>(credential, headers);
        String url="https://uatapi.earlysalary.com/token/esapi/generateTokenNew";
       ResponseEntity<ObjectNode> objectNode=restTemplate.exchange(url, HttpMethod.POST,entity, ObjectNode.class);
       if(objectNode.getBody().get("statusCode").asInt()==200){
           token= objectNode.getBody().get("token").toString();
           log.info(token);
           return objectNode.getBody();
       }
        return objectNode.getBody();
    }
    //lead
    public ObjectNode leadPost(Lead lead){
        HttpHeaders header= new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        header.set("token",token);
        HttpEntity<Lead> entity= new HttpEntity<>(lead,header);
        String url="https://uatapi.earlysalary.com/espiqa/profile-ingestion";
      ResponseEntity<ObjectNode> responseNode  =restTemplate.exchange(url,HttpMethod.POST,entity,ObjectNode.class);
      return responseNode.getBody();
    }


    ////not woeking
    public ObjectNode customerStatus(String key,String value){
        HttpHeaders header= new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        header.set("Authorization",token);
       HttpEntity<String> entity= new HttpEntity<>(header);
        String url="https://uatapi.earlysalary.com/hrms/fetchcuststatus";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", value);

       ResponseEntity<ObjectNode> node= restTemplate.exchange(builder.toUriString(),HttpMethod.POST,entity,ObjectNode.class);
        return node.getBody();
    }
}
