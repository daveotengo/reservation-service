package com.example.reservationservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	@Id
	private String id;
	
	private String name;

}
