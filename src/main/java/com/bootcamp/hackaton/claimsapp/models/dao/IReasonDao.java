package com.bootcamp.hackaton.claimsapp.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bootcamp.hackaton.claimsapp.models.entity.Problem;
import com.bootcamp.hackaton.claimsapp.models.entity.Reason;

public interface IReasonDao extends CrudRepository<Reason,Long>{

	@Query(value="select * from reasons where problem_id =?1", nativeQuery=true)
	public List<Reason> findReasonByProblemId(Long problemId);
}
