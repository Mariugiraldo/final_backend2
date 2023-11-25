package com.example.msusers.repository;

import com.example.msusers.domain.BillsDTO;
import com.example.msusers.feign.FeignInterceptor;
import com.example.msusers.feign.OAuthFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "subscription-service",url = "http://localhost:8086", configuration = OAuthFeignConfig.class)
public interface FeignUserRepository {

    @RequestMapping(method = RequestMethod.GET,value = "/bills/find")
    ResponseEntity<BillsDTO> findByUserId(@RequestParam Integer userId);
}
