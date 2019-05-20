package com.demo.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.domain.Dificulty;
import com.demo.jpa.domain.Region;
import com.demo.jpa.domain.Tour;
import com.demo.jpa.domain.TourPackage;
import com.demo.jpa.exceptions.TourPackageExistsException;
import com.demo.jpa.repository.TourPackageRepository;
import com.demo.jpa.repository.TourRepository;

@Service
public class TourService {

	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;

	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}

	public Tour createTour(String title, String description, String blurb, double price, String duration,
			String bullets, String keywords, Region region, Dificulty difficulty, String tourPackageCode)
			throws TourPackageExistsException {

		TourPackage tourPackage = tourPackageRepository.findById(tourPackageCode).orElse(null);
		if (null == tourPackage) {
			throw new TourPackageExistsException("Tour Package Does not Exist : " + tourPackageCode, tourPackageCode,
					"");
		}

		return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, region,
				difficulty, tourPackage));
	}

	public Iterable<Tour> lookup() {
		return tourRepository.findAll();
	}

	public long total() {
		return tourRepository.count();
	}

}
