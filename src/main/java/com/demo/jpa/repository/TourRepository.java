/**
 * @author isaack
 * 
 * Extend CRUD repository for Ordinary repositories.
 * 
 * 
 * For To support Sorting and Paging APIS, Change the to Paging and Sorting Repository (PagingAndSortingRepository)
 * Also, Instead of returning a list of data in one list, you can return a page instead (Page). 
 * 
 * When Calling the API< Call
 */

package com.demo.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.demo.jpa.domain.Tour;

@Repository

@RepositoryRestResource(collectionResourceRel = "tours", path = "tours")
public interface TourRepository extends PagingAndSortingRepository<Tour, Long> {

	Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

	@Override
	/**
	 * @RestResource annotation helps control API Exposure.
	 */
	@RestResource(exported = false)
	<S extends Tour> S save(S entity);

	@Override
	@RestResource(exported = false)
	<S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

	@Override
	@RestResource(exported = false)
	void delete(Tour entity);

	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends Tour> entities);

	@Override
	@RestResource(exported = false)
	void deleteAll();

}
