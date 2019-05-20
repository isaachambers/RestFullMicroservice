package com.demo.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.domain.TourPackage;
import com.demo.jpa.exceptions.TourPackageExistsException;
import com.demo.jpa.repository.TourPackageRepository;

@Service
public class TourPackageService {

	private TourPackageRepository packageRepository;

	@Autowired
	public TourPackageService(TourPackageRepository packageRepository) {
		this.packageRepository = packageRepository;
	}

	public TourPackage createTourPackage(String code, String name) throws TourPackageExistsException {
		TourPackage tourPackage = packageRepository.findById(code).orElse(null);
		if (null == tourPackage) {
			return packageRepository.save(new TourPackage(code, name));
		} else {
			throw new TourPackageExistsException("Tour Package with code " + code + " already exists", code, name);
		}
	}

	public Iterable<TourPackage> lookup() {
		return packageRepository.findAll();
	}

}
