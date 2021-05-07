package com.bootcamp.hackaton.claimsapp.models.services;

import java.util.List;

import com.bootcamp.hackaton.claimsapp.models.dto.ClaimDto;
import com.bootcamp.hackaton.claimsapp.models.dto.ProblemDto;
import com.bootcamp.hackaton.claimsapp.models.dto.ReasonDto;


public interface IClaimService {
	public List<ClaimDto> findAll();
	public ClaimDto save(ClaimDto claim);
	public List<ClaimDto> getClaimsByCustomerId(String customerId);
	public List<ClaimDto> getClaimsById(Long claimId);
	public List<ReasonDto> getReasonByProblemId(Long problemId);
	public List<ProblemDto> getProblemByProductId(Long productId);
}
