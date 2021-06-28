/**
 * 
 */
package com.solutio.microservicePersistence.service;

import java.util.List;

import com.solutio.microservicePersistence.model.Tweet;

/**
 * @author Yuto
 *
 */
public interface TweetsService {

	List<Tweet> getTweets() throws Exception;
	
	String validateTweet(int id, boolean validate) throws Exception;
	
	List<String> getTrend(int top) throws Exception;
	
}
