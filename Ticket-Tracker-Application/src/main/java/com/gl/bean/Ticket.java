package com.gl.bean;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int id;
	String ticketTitle;
	String description;
	LocalDate ticketCreated;

}
