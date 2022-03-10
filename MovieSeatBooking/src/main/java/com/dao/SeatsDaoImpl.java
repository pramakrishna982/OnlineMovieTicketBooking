package com.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.context.AppContext;
import com.entity.Booking;
import com.entity.Movie;
import com.entity.Seats;
import com.entity.ShowMovie;

//@Transactional
@Repository
@Service
public class SeatsDaoImpl implements SeatsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private AppContext con;

	@Override
	public boolean insert(Seats seat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Seats> getAllSeats() {

		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Seats> cq = cb.createQuery(Seats.class);
		Root<Seats> root = cq.from(Seats.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
		// return null;
	}
	
	@Override
	public List<Movie> getMovie(){
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		//cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}
	
	@Override
	public Seats getUpdate(int seat_no) {
		// TODO Auto-generated method stub
		Session session = (Session) con.sessionFactory();
		Transaction t = session.beginTransaction();
		session.save(seat_no);
		t.commit();
		session.close();
		return null;
	}
	
	@Override
	public Seats getInsert(int seat_no, boolean seat_status) {
		// TODO Auto-generated method stub
		Seats s = new Seats();
		s.setSeat_no(seat_no);
		s.setSeat_status(true);
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
		System.out.println(seat_status);
		System.out.println("Seat no from impl " + seat_no);
		return s;
	}
	
	@Override
	public Booking getAlltickets(Date show_date, String time) {
		// TODO Auto-generated method stub
		Booking book= new Booking();
		book.setShow_date(show_date);
		book.setStart_time(time);
		Session session = sessionFactory.getCurrentSession();
		session.update(book);
		return book;
	}

	@Override
	public Seats getSeat_No(int seat_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowMovie> getMovies(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}