package com.kh.moviebox.reservation.model.vo;

import java.util.List;

import com.kh.moviebox.common.model.vo.Attachment;
import com.kh.moviebox.common.model.vo.Price;
import com.kh.moviebox.movie.model.vo.Movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Reservation {
	private int ticketNo;
	private int personNum;
	private int memberNo;
	private int screenNo;
	private int movieNo;
	private String runningTime;
	private String status;
	private String movieTitle;
	private String theaterName;
	private String watchDate;
	private String reservationDate;
	private String screenName;
	private Movie movie;
	private boolean beforeCurrent;
	private Attachment attachment;
	private Price price;
	private List<Seat> seatList;
}
