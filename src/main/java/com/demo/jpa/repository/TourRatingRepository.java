package com.demo.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.demo.jpa.domain.TourRating;

@Repository
@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRating> {

	/**
	 * Lookup all tour ratings for a tour.
	 * 
	 * @param tourId
	 * @return List of Tour Ratings
	 */
	List<TourRating> findByPkTourId(Long tourId);
	
	
	Page<TourRating> findByPkTourId(Long tourId, Pageable pageable);

	TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Long CustomerId);

}
