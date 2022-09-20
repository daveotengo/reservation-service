package com.example.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@Log4j2
public class SampleDataInitializer {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void initialize() {
		
		//Flux<String> names =Flux.just("Josh","Cornellia","Dr. syer","Stephanie");
		
		var saved =Flux.just("Josh","Cornellia","Dr. syer","Stephanie")
				.map(name-> new Reservation(null,name)).
				flatMap(this.reservationRepository::save);
		
		reservationRepository
		.deleteAll().
		thenMany(saved).
		thenMany(this.reservationRepository.findAll())
		.subscribe(log::info);
		
	}

}
