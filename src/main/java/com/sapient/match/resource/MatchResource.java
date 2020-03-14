package com.sapient.match.resource;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.match.exception.InvalidMatchUniqueIdException;
import com.sapient.match.model.MatchResult;
import com.sapient.match.service.MatchService;

@RestController
public class MatchResource {
	
	@Autowired
	MatchService matchService;
	
	@GetMapping("/api/cricketScore/{matchUniqueID}")
	public ResponseEntity<MatchResult> getMatchResult(@PathVariable(value = "matchUniqueID") String matchUniqueID){
		System.out.println("Inside getMatchResuult : "+matchUniqueID);
		MatchResult result = matchService.getMatchResult(matchUniqueID);
		if(result == null){
			throw new InvalidMatchUniqueIdException("Invalid Match UninqueId.");
		}
		
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	@GetMapping("/api")
	public String getHello(){
		
		return "Hello World";
	}

}
