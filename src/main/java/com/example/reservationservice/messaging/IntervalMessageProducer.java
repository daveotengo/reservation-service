package com.example.reservationservice.messaging;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.example.reservationservice.entity.GreetingRequest;
import com.example.reservationservice.entity.GreetingResponse;

import reactor.core.publisher.Flux;

@Component
public class IntervalMessageProducer {
	
//	Flux<String> producer(String name){
//		return Flux.fromStream(Stream.generate(new Supplier<String>() {
//
//			@Override
//			public String get() {
//				// TODO Auto-generated method stub
//				return "hELLO" + name + "@" + Instant.now();
//			}
//			
//		}))
//				.delayElements(Duration.ofSeconds(1))
//				;
//		
//	}
	
	public Flux<GreetingResponse> produceGreetings(GreetingRequest name){
		return Flux.fromStream(Stream.generate(()->
				 "hELLO" + name.getName() + "@" + Instant.now()))
				.map(GreetingResponse::new)
				.delayElements(Duration.ofSeconds(1));
				
		
	}

}
