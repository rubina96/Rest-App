package com.example.restApplication.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.restApplication.entity.OrderEntity;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class RestService {
//	@Autowired
//	OrderRepo orderRepo;
	
	//@Cacheable(value ="order-service",key="#id")
//	@CircuitBreaker(name="getOrder",fallbackMethod = "failedToGetOrder")
//	@TimeLimiter(name="getOrder",fallbackMethod = "failedToGetOrder")
//	@RateLimiter(name="getOrder")
//	@Retry(name="getOrder")
//	@Bulkhead(name="getOrder",  type = Bulkhead.Type.SEMAPHORE)
	public OrderEntity getOrder(Long id) {
	    System.out.println("DATABASE WAS CALLED");

		//return orderRepo.findById(id).get();
	    return null;
	}
	
	public OrderEntity insertOrder(OrderEntity entity) {
		//return orderRepo.save(entity);
	    return null;

	}
	
	public void failedToGetOrder() {
		System.out.println("getOrderFailed");
	}
	
	public void newString(String s) {
		s="I love Java";
		String result="#"+s.replace(" ", "");
		System.out.println(result);
	}
}
