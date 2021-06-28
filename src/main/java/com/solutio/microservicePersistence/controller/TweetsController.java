/**
 * 
 */
package com.solutio.microservicePersistence.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solutio.microservicePersistence.model.Tweet;
import com.solutio.microservicePersistence.service.impl.TweetsServiceImpl;

/**
 * @author Yuto
 *
 */
@RestController
public class TweetsController {

	@Autowired
	TweetsServiceImpl tweetsServiceImpl;
	
	@GetMapping("/tweets")
	private ResponseEntity<List<Tweet>> getTweets() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		tweets = tweetsServiceImpl.getTweets();
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(tweets);
	}
	
	@GetMapping("/trends")
	private ResponseEntity<List<String>> getTrends(@RequestParam(required=false, defaultValue = "10") int top) {
				
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(tweetsServiceImpl.getTrend(top));
	}
	
	
	@GetMapping("/validate")
	private ResponseEntity<String> validateTweet(@RequestParam(required = true) int id, @RequestParam(required=false, defaultValue="0") boolean validate) {
		
		String resp = tweetsServiceImpl.validateTweet(id, validate);
		
		if(resp.equals("KO")) {
			return ResponseEntity.badRequest().body("Error validating the tweet");
		}
				
		return ResponseEntity.ok("Tweet " + id + " was validated: " + validate);
	}
}
