package com.demo.jpa.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.domain.Tour;
import com.demo.jpa.domain.TourRating;
import com.demo.jpa.domain.TourRatingPk;
import com.demo.jpa.repository.TourRatingRepository;
import com.demo.jpa.repository.TourRepository;
import com.demo.jpa.web.domain.RatingDto;

import io.swagger.annotations.Api;

@Api(description = "Returns a list of Paginated Ratings")
@RestController
@RequestMapping(path = "tours/{tourId}/ratings")
public class TourRatingController {

	private TourRepository tourRepository;
	private TourRatingRepository tourRatingRepository;

	@Autowired
	public TourRatingController(TourRepository tourRepository, TourRatingRepository tourRatingRepository) {
		this.tourRatingRepository = tourRatingRepository;
		this.tourRepository = tourRepository;
	}

	protected TourRatingController() {

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createTourRating(@PathVariable("tourId") long tourId, @RequestBody @Validated RatingDto ratingDto) {
		Tour tour = verifyTour(tourId);
		tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDto.getCustomerId()),
				ratingDto.getScore(), ratingDto.getComment()));
	}

	/**
	 * First Implementation that does not require Pagination.
	 * 
	 * @param tourId
	 * @return Returns a list of tour ratings.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<RatingDto> getTourRatings(@PathVariable("tourId") long tourId) {
		verifyTour(tourId);
		List<RatingDto> ratings = new ArrayList<RatingDto>();
		tourRatingRepository.findByPkTourId(tourId).forEach(tourRating -> ratings.add(tourRating(tourRating)));
		return ratings;

	}

//	 @PostMapping("/{score}")
//	    @ResponseStatus(HttpStatus.CREATED)
//	    public void createManyTourRatings(@PathVariable(value = "tourId") int tourId,
//	                                      @PathVariable(value = "score") int score,
//	                                      @RequestParam("customers") Integer customers[]) {
//	        tourRatingService.rateMany(tourId, score, customers);
//	    }

	/**
	 * First Implementation that does/performs Pagination.
	 * 
	 * @param tourId
	 * @return Returns a list of tour ratings.
	 */

	@RequestMapping(method = RequestMethod.GET, path = "/paginated")

	public Page<RatingDto> getTourRatingsPaginates(@PathVariable("tourId") long tourId, Pageable pageable) {
		verifyTour(tourId);
		Page<TourRating> tourRatingsPage = tourRatingRepository.findByPkTourId(tourId, pageable);

		List<RatingDto> ratings = tourRatingsPage.getContent().stream().map(tourRating -> tourRating(tourRating))
				.collect(Collectors.toList());
		return new PageImpl<>(ratings, pageable, tourRatingsPage.getTotalPages());

	}

	RatingDto tourRating(TourRating rating) {
		return new RatingDto(rating.getScore(), rating.getComment(), rating.getPk().getCustomerId());

	}

	@RequestMapping(method = RequestMethod.GET, path = "/average")
	public Map<String, OptionalDouble> getAvarage(@PathVariable long tourId) {
		verifyTour(tourId);
		Map<String, OptionalDouble> data = new HashMap<>();
		List<TourRating> tourRatings = tourRatingRepository.findByPkTourId(tourId);
		OptionalDouble average = tourRatings.stream().mapToDouble(TourRating::getScore).average();
		data.put("average", average);
		return data;

	}

	private Tour verifyTour(long tourId) throws NoSuchElementException {
		Tour tour = tourRepository.findById(tourId).orElse(null);
		if (tour == null) {
			throw new NoSuchElementException("Tour does not exist " + tourId);
		}
		return tour;

	}

	/**
	 * Exception Handler for NoSuchElementException
	 * 
	 * @param ex
	 * @return Error Message as a String
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();
	}

}
