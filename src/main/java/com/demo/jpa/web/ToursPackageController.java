package com.demo.jpa.web;

//@RestController
//@RequestMapping(path = "tourpackages")
public class ToursPackageController {

//	@Autowired
//	private TourPackageService tourpackageService;
//
//	@RequestMapping(path = "", method = RequestMethod.POST)
//	public ResponseEntity<Object> saveNewEntity(@RequestBody TourPackage tourPackage) {
//
//		try {
//			return new ResponseEntity<Object>(
//					tourpackageService.createTourPackage(tourPackage.getCode(), tourPackage.getName()), HttpStatus.OK);
//		} catch (TourPackageExistsException e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//		} catch (Exception e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@RequestMapping(path = "", method = RequestMethod.GET)
//	public ResponseEntity<Object> getAllTours() {
//		List<TourPackage> tours = new ArrayList<>();
//		tourpackageService.lookup().forEach(tourpackage -> tours.add(tourpackage));
//		try {
//			return new ResponseEntity<Object>(tours, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
