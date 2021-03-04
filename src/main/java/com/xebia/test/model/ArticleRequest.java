/**
 * 
 */
package com.xebia.test.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author tomar
 *
 */
@Getter
@Setter
public class ArticleRequest {
	
	@NonNull
	private String title;
	@NonNull
	private String description;
	@NonNull
	private String body;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
