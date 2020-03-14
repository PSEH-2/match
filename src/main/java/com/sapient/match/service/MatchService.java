package com.sapient.match.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sapient.match.model.MatchResult;

@Service
public class MatchService {

	private Map<String, MatchResult> matchMap = new HashMap<>();
	MatchResult r1 = new MatchResult("Sunrisers Hyderabad", "Chennai Super Kings (winner)", "140/8", "8140/");
	
	
	
	public MatchResult getMatchResult(String matchUniqueId){
		matchMap.put("1136617",r1);
		return matchMap.getOrDefault(matchUniqueId, null);
		
	}

}
