package com.dao;

import java.util.Date;

import com.entity.Booking;

public interface BookingDao {
	
	public Booking getAlltickets(Date date, String time );

}
