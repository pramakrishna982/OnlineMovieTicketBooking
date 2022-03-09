package com.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.entity.Movie;
import com.entity.ShowMovie;
//@Transactional
@Repository
@Service
public class MovieDaoImpl implements MovieDao{
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
    public List < ShowMovie > getShowMovie() {
    	System.out.println("inside MoviedaoImpl class inside list movie method ");
    	
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < ShowMovie > cq = cb.createQuery(ShowMovie.class);
        Root < ShowMovie > root = cq.from(ShowMovie.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List <ShowMovie> list=query.getResultList();
        System.out.println(list.toString()+list.size());
        return list;
    }
	


	@Override
	public List<ShowMovie> getMovies(int id) {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < ShowMovie > cq = cb.createQuery(ShowMovie.class);
        Root < ShowMovie > root = cq.from(ShowMovie.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        
        List <ShowMovie> list=query.getResultList();
        
        System.out.println(list.toString()+list.size());
        
        return query.getResultList();
	}
	
	@Override
	public ShowMovie getMovie(int id) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	ShowMovie movie = session.byId(ShowMovie.class).load(id);
	System.out.println(movie.toString());
	//System.out.println(list.toString()+list.size());
	return movie;
	
	}
}