package com.bootcamp.hackaton.claimsapp.models.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bootcamp.hackaton.claimsapp.models.entity.Problem;

public interface IProblemDao extends CrudRepository<Problem,Long> {

	@Query(value="select * from problems where product_id =?1", nativeQuery=true)
	public List<Problem> findProblemByProductId(Long productId);
}
