/**
 * 
 */
package com.solutio.microservicePersistence.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.solutio.microservicePersistence.model.Tweet;
import com.solutio.microservicePersistence.repository.TweetRepository;
import com.solutio.microservicePersistence.service.TweetsService;

/**
 * @author Yuto
 *
 */
@Service
public class TweetsServiceImpl implements TweetsService {

	@Autowired
	TweetRepository tweetRepository;
	
	@Override
	public List<Tweet> getTweets() {
		
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(URI.create("http://localhost:8081/tweets"), String.class);
		int cont = 0;
		JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
		for (JsonElement jsonElement : jsonArray) {
			if(jsonElement.isJsonObject()) {
				Tweet tweet = new Tweet();
				tweet.setId(cont++);
				tweet.setUser(jsonElement.getAsJsonObject().get("user").toString());
				tweet.setLocation(jsonElement.getAsJsonObject().get("location").toString());
				tweet.setText(jsonElement.getAsJsonObject().get("text").toString());
				saveUpdateTweet(tweet);
			}
		}
				
		tweetRepository.findAll().forEach(tweet -> tweets.add(tweet));

		return tweets;
	}

	@Override
	public String validateTweet(int id, boolean validate) {
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
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(URI.create("http://localhost:8081/trends/?top="+top), String.class);
		JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
		List<String> resp = new ArrayList<String>();
		jsonArray.forEach(element -> resp.add(element.getAsString()));
		
		return resp;
	}

	public Tweet getTweet(int id) {
		return tweetRepository.findById(id).get();
	}

	public void saveUpdateTweet(Tweet tweet) {
		tweetRepository.save(tweet);
	}

}
