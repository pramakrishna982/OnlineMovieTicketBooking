package com.entity;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="showmovie")
public class ShowMovie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int id;
	
	@Column(name="movie_name")
	private String name;
	
	@Column(name="duration")
	private String duration;
	
	private byte[] image;  
	 
    @Column(name = "image")
    public byte[] getImage() {
        return this.image;
    }
 
    private String base64Image;
    @Transient
    public String getBase64Image() {
    	base64Image = Base64.getEncoder().encodeToString(this.image);
        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

	@Column(name="Actors_names")
	private String cast_names;
	
	@Column(name="language")
	private String Language;
	
	@Column(name = "show_date")
	private Date show_date;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCast_names() {
		return cast_names;
	}

	public void setCast_names(String cast_names) {
		this.cast_names = cast_names;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

	public Date getShow_date() {
		return show_date;
	}

	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}
	
	public ShowMovie(int id, String name, String duration, byte[] image, String base64Image, String cast_names,
			String language, Date show_date) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.image = image;
		this.base64Image = base64Image;
		this.cast_names = cast_names;
		Language = language;
		this.show_date = show_date;
	}
	
	public ShowMovie() {
		super();
	}

	@Override
	public String toString() {
		return "ShowMovie [id=" + id + ", name=" + name + ", duration=" + duration + ", image=" + Arrays.toString(image)
				+ ", base64Image=" + base64Image + ", cast_names=" + cast_names + ", Language=" + Language
				+ ", show_date=" + show_date + "]";
	}

}
