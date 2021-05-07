package com.bootcamp.hackaton.claimsapp.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.hackaton.claimsapp.models.entity.Claim;

public interface IClaimDao extends CrudRepository<Claim,Long> {

	
	public List<Claim> findClaimsByCustomerId(String customerId);
	public List<Claim> findClaimsById(Long claimId);
	public List<Claim> findClaimsByProductId(Long productId);
	public List<Claim> findClaimsByProblemId(Long problemId);
}
