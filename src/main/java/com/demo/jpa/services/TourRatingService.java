package com.demo.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.domain.TourRating;
import com.demo.jpa.domain.TourRatingPk;
import com.demo.jpa.repository.TourRatingRepository;
import com.demo.jpa.repository.TourRepository;

@Service
public class TourRatingService {

	private TourRepository tourRepository;
	private TourRatingRepository tourRatingRepository;

	@Autowired
	public TourRatingService(TourRepository tourRepository, TourRatingRepository tourRatingRepository) {
		this.tourRepository = tourRepository;
		this.tourRatingRepository = tourRatingRepository;
	}

	public void save(TourRating tourRating) {

		tourRatingRepository.save(tourRating);
	}

	public List<TourRating> findByPkTourId(long tourId) {
		return tourRatingRepository.findByPkTourId(tourId);

	}

	public void rateMany(long tourId, int score, Long[] customers) {
		tourRepository.findById(tourId).ifPresent(tour -> {
			for (Long customer : customers) {
				tourRatingRepository.save(new TourRating(new TourRatingPk(tour, customer), score, ""));
			}
		});

	}

}
