package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.Booking;
import com.entity.Movie;
import com.entity.Seats;

public interface SeatsDao {

	public boolean insert(Seats seat);

	public List<Seats> getAllSeats();

	public Seats getSeat_No(int seat_no);

	Booking getAlltickets(Date show_date, String time);

	Seats getInsert(int seat_no, boolean seat_status);

	Seats getUpdate(int seat_no);

	List<Movie> getMovie();
}