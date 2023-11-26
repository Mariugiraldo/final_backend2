package com.example.msusers.feign;

import com.example.msusers.configuration.FeignAuthInterceptor;
import com.example.msusers.controller.response.BillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-bills", url = "http://localhost:8086", configuration = FeignAuthInterceptor.class)
public interface BillClient {

    @RequestMapping(method = RequestMethod.GET, value = "/bills/{id}")
    List<BillDTO> findByUserId(@RequestParam String id);
}
