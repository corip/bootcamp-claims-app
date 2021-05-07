package com.bootcamp.hackaton.claimsapp.models.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.hackaton.claimsapp.models.dao.IClaimDao;
import com.bootcamp.hackaton.claimsapp.models.dao.IProblemDao;
import com.bootcamp.hackaton.claimsapp.models.dao.IReasonDao;
import com.bootcamp.hackaton.claimsapp.models.dto.ClaimDto;
import com.bootcamp.hackaton.claimsapp.models.dto.ProblemDto;
import com.bootcamp.hackaton.claimsapp.models.dto.ReasonDto;
import com.bootcamp.hackaton.claimsapp.models.entity.Claim;
import com.bootcamp.hackaton.claimsapp.models.entity.Problem;
import com.bootcamp.hackaton.claimsapp.models.entity.Reason;

import org.springframework.beans.BeanUtils;

@Service
public class ClaimServiceImpl implements IClaimService{

	@Autowired
	private IClaimDao claimDao;
	
	@Autowired
	private IProblemDao problemDao;
	
	@Autowired
	private IReasonDao reasonDao;
	
	@Override
	public List<ClaimDto> findAll() {
		// TODO Auto-generated method stub
		List<Claim> lsClaimsTmp = (List<Claim> )claimDao.findAll();
		List<ClaimDto> lsClaimsDto =  new ArrayList();
		
		
		lsClaimsTmp.forEach(element ->{
			ClaimDto  claimDto= new ClaimDto();
			BeanUtils.copyProperties(element, claimDto);
			claimDto.setProductNumber(element.getProduct().getId());
			claimDto.setChannelId(element.getChannel().getId());
			claimDto.setReasonId(element.getReason().getId());
			claimDto.setProblemId(element.getProblem().getId());
			lsClaimsDto.add(claimDto);
			
		});
		
		return lsClaimsDto;
	}
	
	@Override
	public ClaimDto save(ClaimDto claim) {
		// TODO Auto-generated method stub
		Claim claimEntity = new Claim();
		BeanUtils.copyProperties(claim, claimEntity);
		claimEntity.getProduct().setId(claim.getProductNumber());
		claimEntity.getChannel().setId(claim.getChannelId());
		claimEntity.getProblem().setId(claim.getProblemId());
		claimEntity.getReason().setId(claim.getReasonId());

		claimEntity = claimDao.save(claimEntity);
		
		claim.setId(claimEntity.getId());
		
		return claim;
	}

	@Override
	public List<ClaimDto> getClaimsByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		List<Claim> claim;
		List<ClaimDto> lsClaimDto = new ArrayList();
		claim = claimDao.findClaimsByCustomerId(customerId);
		
		claim.forEach(element ->{
			ClaimDto  claimDto= new ClaimDto();
			BeanUtils.copyProperties(element, claimDto);
			claimDto.setProductNumber(element.getProduct().getId());
			claimDto.setChannelId(element.getChannel().getId());
			claimDto.setReasonId(element.getReason().getId());
			claimDto.setProblemId(element.getProblem().getId());
			lsClaimDto.add(claimDto);
			
		});
		
		return lsClaimDto;
	}

	@Override
	public List<ClaimDto> getClaimsById(Long claimId) {
		// TODO Auto-generated method stub
		List<Claim> claim;
		List<ClaimDto> lsClaimDto = new ArrayList();
		claim = claimDao.findClaimsById(claimId);
		
		claim.forEach(element ->{
			ClaimDto  claimDto= new ClaimDto();
			BeanUtils.copyProperties(element, claimDto);
			claimDto.setProductNumber(element.getProduct().getId());
			claimDto.setChannelId(element.getChannel().getId());
			claimDto.setReasonId(element.getReason().getId());
			claimDto.setProblemId(element.getProblem().getId());
			
			lsClaimDto.add(claimDto);
			
		});
		
		return lsClaimDto;
	}

	@Override
	public List<ProblemDto> getProblemByProductId(Long productId) {
		// TODO Auto-generated method stub
		List<Problem> problems;
		List<ProblemDto> lsProblemDto = new ArrayList();
		problems = problemDao.findProblemByProductId(productId);
		
		problems.forEach(element ->{
			ProblemDto  problemDto= new ProblemDto();
			BeanUtils.copyProperties(element, problemDto);
		
			
			lsProblemDto.add(problemDto);
		});
	
		
		return lsProblemDto;
		
	}

	@Override
	public List<ReasonDto> getReasonByProblemId(Long problemId) {
		// TODO Auto-generated method stub
		List<Reason> reasons;
		List<ReasonDto> lsreasonDto = new ArrayList();
		reasons = reasonDao.findReasonByProblemId(problemId);
		
		reasons.forEach(element ->{
			ReasonDto  reasonDto= new ReasonDto();
			BeanUtils.copyProperties(element, reasonDto);
		
			
			lsreasonDto.add(reasonDto);
		});
		
		return lsreasonDto;
	}



	
	
	

}
