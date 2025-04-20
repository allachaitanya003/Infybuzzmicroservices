package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.response.AddressResponse;

//@FeignClient(url="${address.service.url}",value = "address-feign-client",path = "/api/address")
//@FeignClient(value="address-service",path = "/api/address")
@FeignClient(value="api-gateway")
public interface AddressClient {
	
	//@GetMapping("/getById/{id}")
	//public AddressResponse getById(@PathVariable Long id);
	
	@GetMapping("/address-service/api/address/getById/{id}")
	public AddressResponse getById(@PathVariable Long id);

}
