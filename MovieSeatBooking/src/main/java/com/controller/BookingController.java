package com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dao.MovieDaoImpl;
import com.dao.SeatsDaoImpl;
import com.entity.ShowMovie;
import com.entity.Movie;
import com.entity.Seats;

@Controller
@Transactional
@Repository
@EnableWebMvc
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private SeatsDaoImpl dao;

	@Autowired
	private MovieDaoImpl movieDaoImpl;

//	@GetMapping(value = "/listseat")
//	public String SeatBooking(Model theModel) {// Model is Interface ,theModel is object
//		System.out.println("In SeatBooking method ");
//		List<Seats> seat = dao.getAllSeats();
//		List<Movie> getmovie = dao.getMovie();
//		theModel.addAttribute("movies", getmovie);
//		System.err.println(getmovie.toString());
//		theModel.addAttribute("seats", seat);// seats is an attribute, seat is object
//		return "bookingseats";
//	}

//	@GetMapping(value = "/submit")
//	public String insertSeats(@RequestParam("seat_no") int seat_no, boolean seat_status, Model Model) {
//	System.out.println("inside insert seat method");
//	Seats seat = dao.getInsert(seat_no, seat_status);
//	System.out.println("seat we want: "+seat_no);
//	//seat.setSeat_status(true);
//	System.out.println("seat status: "+seat_status);
//	Model.addAttribute("insert", seat);
//	return "bookingseats";
	
	@RequestMapping(value = "/submit")
	public String insertSeats(@RequestParam("seat_no[]") int seat_no[], boolean seat_status, Model Model) {
		System.out.println("inside insert seat method");
		for(int i=0;i<seat_no.length;i++) {
		Seats seat = movieDaoImpl.getInsert(seat_no[i], seat_status);
		Model.addAttribute("insert", seat);}
		return "bookingseats";
	}
//	
//	@GetMapping(value = "/listtickets")
//	public String TicketBooking(Model theModel, Movie movie,Date date, String time){
//		System.out.println("ticketBooking  for team ");
//		Booking ticket = dao.getAlltickets(date, time);
//		theModel.addAttribute("tickets", ticket);
//		theModel.addAttribute("movies",movie);
//		return "bookingseats";
//	}

	@RequestMapping(value = "/list")
	public String listMovies(Model m) {
		System.out.println(" inside Movie Controller inside List method");
		List<ShowMovie> movies = movieDaoImpl.getShowMovie();
		for (ShowMovie m1 : movies) {
			System.out.println(m1.toString());
		}
		m.addAttribute("movieslist", movies);

		return "index";
	}

	@RequestMapping(value = "/book" ) 
	public String BookMovies(@RequestParam(value="btnSubmit") int id, Model m) {
	  System.out.println(" inside Movie Controller inside book method : " + id);
	  
	  ShowMovie movies = movieDaoImpl.getMovie(id);
	  //System.out.println(movies.toString());
	  m.addAttribute("book", movies.getName()); 
	  return "bookingseats"; 
	  //return "moviedetails";
	  
	  }

//	
//	  @RequestMapping(value = "/book" ) 
//	  public String BookMovies(@RequestParam(value="btnSubmit") int id, Model m) {
//	  System.out.println(" inside Movie Controller inside book method : " + id);
//	  
//	  ShowMovie movies = movieDaoImpl.getMovie(id);
//	  //System.out.println(movies.toString()); SimpleDateFormat formatter= new
//	  SimpleDateFormat("dd/MM/yyyy");
//	  Date date = new Date(); 
//	  String currentdate=formatter.format(date); 
//	  System.out.println("current date is :" +currentdate);
//	  m.addAttribute("book", movies.getName());
//	  m.addAttribute("todaydate", currentdate);
//	  return "bookingseats"; 
//	  //return "moviedetails";
//	  
//	  }
//	 
}
