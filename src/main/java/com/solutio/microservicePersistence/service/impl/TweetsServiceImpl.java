/**
 * 
 */
package com.solutio.microservicePersistence.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutio.microservicePersistence.model.Tweet;
import com.solutio.microservicePersistence.repository.TweetRepository;
import com.solutio.microservicePersistence.service.TweetsService;

/**
 * @author Yuto
 *
 */
@Service
public class TweetsServiceImpl implements TweetsService{

	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public List<Tweet> getTweets() {
		// TODO Auto-generated method stub
		List<Tweet> tweets = new ArrayList<Tweet>();	
		
		// TODO call to microserviceTweets in order to fill the database
		tweetRepository.findAll().forEach(tweet -> tweets.add(tweet));
		
		return tweets;
	}

	@Override
	public String validateTweet(int id, boolean validate) {
		// TODO Auto-generated method stub
		try {
			Tweet tweet = getTweet(id);
			tweet.setValidation(validate);
			saveUpdateTweet(tweet);
		} catch (Exception e) {
			return "KO";
		}
		
		return "OK";
	}

	@Override
	public List<String> getTrend(int top) {
		// TODO call to microserviceTweets in order to return the trend
		return null;
	}
	
	public Tweet getTweet(int id) {
		return tweetRepository.findById(id).get();
	}
	
	public void saveUpdateTweet (Tweet tweet) {
		tweetRepository.save(tweet);
	}

}
