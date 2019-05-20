package com.demo.jpa.web.domain;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RatingDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Min(0)
	@Max(5)
	private double score;
	@Size(max = 255)
	@NotNull
	private String comment;
	@NotNull
	private long customerId;

	/**
	 * Constructor to Initialize the rating DTO
	 * 
	 * @param score
	 * @param comment
	 * @param customerId
	 */
	public RatingDto(@Min(0) @Max(5) double score, @Size(max = 255) String comment, @NotNull long customerId) {
		super();
		this.score = score;
		this.comment = comment;
		this.customerId = customerId;
	}

	public RatingDto() {
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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
