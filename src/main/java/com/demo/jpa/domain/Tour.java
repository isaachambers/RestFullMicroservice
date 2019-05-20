package com.demo.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tour implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String title;

	@Column(length = 2000)
	private String description;

	@Column(length = 2000)
	private String blurb;

	@Column
	private double price;

	@Column
	private String duration;

	@Column
	private String bullets;

	@Column
	private String keywords;

	@Column
	private Region region;

	@Column
	private Dificulty difficulty;

	@ManyToOne
	@JoinColumn
	private TourPackage tourPackage;

	public Tour() {

	}

	public Tour(String title, String description, String blurb, double price, String duration, String bullets,
			String keywords, Region region, Dificulty difficulty, TourPackage tourPackage) {
		super();
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price;
		this.duration = duration;
		this.bullets = bullets;
		this.keywords = keywords;
		this.region = region;
		this.difficulty = difficulty;
		this.tourPackage = tourPackage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBlurb() {
		return blurb;
	}

	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getBullets() {
		return bullets;
	}

	public void setBullets(String bullets) {
		this.bullets = bullets;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Dificulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Dificulty difficulty) {
		this.difficulty = difficulty;
	}

	public TourPackage getTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

}
