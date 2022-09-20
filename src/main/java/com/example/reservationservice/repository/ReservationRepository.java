package com.example.reservationservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.reservationservice.entity.Reservation;

public interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {

}
