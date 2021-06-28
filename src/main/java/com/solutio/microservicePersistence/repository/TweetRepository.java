/**
 * 
 */
package com.solutio.microservicePersistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.solutio.microservicePersistence.model.Tweet;

/**
 * @author Yuto
 *
 */
public interface TweetRepository extends CrudRepository<Tweet, Integer>{

}
