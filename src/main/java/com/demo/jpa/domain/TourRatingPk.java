package com.demo.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * 
 * @author isaack
 *
 *         Tour Rating Primary Key
 */

@Embeddable
public class TourRatingPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Tour tour;

	@Column(insertable = false, updatable = false, nullable = false)
	private Long customerId;

	public TourRatingPk(Tour tour, Long customerId) {
		super();
		this.tour = tour;
		this.customerId = customerId;
	}

	public TourRatingPk() {

	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "TourRatingPk [tour=" + tour + ", customerId=" + customerId + "]";
	}
	
	

}
