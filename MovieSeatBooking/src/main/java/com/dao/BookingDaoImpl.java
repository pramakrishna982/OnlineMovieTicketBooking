package com.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Booking;

public class BookingDaoImpl implements BookingDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Booking getAlltickets(Date show_date, String time ) {
		// TODO Auto-generated method stub
		
		Booking book= new Booking();
		book.setShow_date(show_date);
		book.setStart_time(time);
		Session session = sessionFactory.getCurrentSession();
		session.update(book);
		return book;
	}

}
