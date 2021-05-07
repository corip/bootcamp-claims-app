package com.bootcamp.hackaton.claimsapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.hackaton.claimsapp.models.dto.ClaimDto;
import com.bootcamp.hackaton.claimsapp.models.dto.ProblemDto;
import com.bootcamp.hackaton.claimsapp.models.dto.ReasonDto;
import com.bootcamp.hackaton.claimsapp.models.services.IClaimService;

@RestController
@RequestMapping("/claims")
public class ClaimsRestController {
	@Autowired
	private IClaimService claimService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		Map<String,Object> response = new  HashMap<>();
		List<ClaimDto> claims;
		
		claims =claimService.findAll();;
		
		response.put("status","aproved");
		response.put("claims",claims);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ClaimDto claim){
		Map<String,Object> response = new  HashMap<>();
		claim=claimService.save(claim);
		response.put("status","aproved");
		response.put("claims",claim);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<?> getClaimsByCustomer(@PathVariable String customerId ){
		Map<String,Object> response = new  HashMap<>();
		List<ClaimDto> lsClaim;
		lsClaim=claimService.getClaimsByCustomerId(customerId);
		response.put("status","aproved");
		response.put("claims",lsClaim);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{claimId}")
	public ResponseEntity<?> getClaimsById(@PathVariable Long claimId ){
		Map<String,Object> response = new  HashMap<>();
		List<ClaimDto> lsClaim;
		lsClaim=claimService.getClaimsById(claimId);
		response.put("status","aproved");
		response.put("claims",lsClaim);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/list/problem/{productId}")
	public ResponseEntity<?> getProblemByProductId(@PathVariable Long productId ){
		Map<String,Object> response = new  HashMap<>();
		List<ProblemDto> lsProblems;
		lsProblems=claimService.getProblemByProductId(productId);
		response.put("status","aproved");
		response.put("claims",lsProblems);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/list/reason/{problemId}")
	public ResponseEntity<?> getReasonByProblem(@PathVariable Long problemId ){
		Map<String,Object> response = new  HashMap<>();
		List<ReasonDto> reasons;
		reasons=claimService.getReasonByProblemId(problemId);
		response.put("status","aproved");
		response.put("claims",reasons);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	
	
	

}
