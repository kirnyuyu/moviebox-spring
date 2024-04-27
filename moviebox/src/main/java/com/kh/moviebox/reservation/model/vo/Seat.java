package com.kh.moviebox.reservation.model.vo;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Seat {
	private String seatNo;
	private int screenNo;
	private int ticketNo;
}
