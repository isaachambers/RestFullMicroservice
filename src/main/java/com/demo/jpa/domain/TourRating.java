package com.demo.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TourRating  implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TourRatingPk pk;

	@Column(nullable = false)
	private double score;

	@Column
	private String comment;

	public TourRating(TourRatingPk pk, double score, String comment) {
		this.pk = pk;
		this.score = score;
		this.comment = comment;
	}

	public TourRating() {

	}

	public TourRatingPk getPk() {
		return pk;
	}

	public void setPk(TourRatingPk pk) {
		this.pk = pk;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "TourRating [pk=" + pk + ", score=" + score + ", comment=" + comment + "]";
	}
	
	
	
}
