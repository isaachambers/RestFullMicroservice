package com.demo.jpa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "tours")
public class ToursController {
	private static Logger logger = LoggerFactory.getLogger(ToursController.class);
//	@Autowired
//	private TourService tourService;
//
//	@RequestMapping(path = "", method = RequestMethod.GET)
//	public ResponseEntity<Object> getAllTours() {
//		List<Tour> tours = new ArrayList<>();
//		tourService.lookup().forEach(tour -> tours.add(tour));
//		try {
//			return new ResponseEntity<Object>(tours, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<Object> createNewTour(@RequestBody Tour tour) {
//		try {
//			return new ResponseEntity<Object>(tourService.createTour(tour.getTitle(), tour.getDescription(),
//					tour.getBlurb(), tour.getPrice(), tour.getDuration(), tour.getBullets(), tour.getKeywords(),
//					tour.getRegion(), tour.getDifficulty(), tour.getTourPackage().getCode()), HttpStatus.OK);
//		} catch (TourPackageExistsException e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public ResponseEntity<Object> testInterceptor() {
		logger.info("Here We are");
		return new ResponseEntity<Object>("Response Data", HttpStatus.OK);
	}
}
