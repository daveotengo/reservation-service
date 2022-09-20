package com.example.reservationservice.restcontroller;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservationservice.entity.GreetingRequest;
import com.example.reservationservice.entity.GreetingResponse;
import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.messaging.IntervalMessageProducer;
import com.example.reservationservice.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReservationRestController {
	private final IntervalMessageProducer intervalMessageProducer;
	private final ReservationRepository reservationRepository;
	
	@GetMapping("reservations")
	public Publisher<Reservation> getReservations(){
		return reservationRepository.findAll();
	}
	
	@GetMapping(produces=MediaType.TEXT_EVENT_STREAM_VALUE,value="/sse/{n}")
	public Publisher<GreetingResponse> sse(@PathVariable String n){
		return intervalMessageProducer.produceGreetings(new GreetingRequest(n));
		
	}
	
	

}
