/**
 * 
 */
package com.solutio.microservicePersistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yuto
 *
 */
@Entity
@Table
public class Tweet {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column	(nullable = false)
	private int id;
	@Column (nullable = true)
	private String user;
	@Column (nullable = true)
	private String text;
	@Column (nullable = true)
	private String location;
	@Column (nullable = true)
	private boolean validation;
	
	/**
	 * @return the user
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
		
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the validation
	 */
	public boolean isValidation() {
		return validation;
	}
	/**
	 * @param validation the validation to set
	 */
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
}
