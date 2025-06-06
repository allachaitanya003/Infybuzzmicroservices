package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomeFilter implements GlobalFilter{
	
	Logger logger = LoggerFactory.getLogger(CustomeFilter.class);

	//pre-filter:  filter executes before calling MS
	//post-filter:  filter will be called after MS execution is completed
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest request = exchange.getRequest();
		
		//if(request.getURI().toString().contains("/api/student"))
		logger.info("Authorization:"+request.getHeaders().getFirst("Authorization"));
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse response = exchange.getResponse();
			logger.info("post filter:"+response.getStatusCode());
		}));
	}
	

}
