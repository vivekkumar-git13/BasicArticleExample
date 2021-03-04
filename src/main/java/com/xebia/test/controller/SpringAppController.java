/**
 * 
 */
package com.xebia.test.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.test.model.Article;
import com.xebia.test.model.ArticleRequest;
import com.xebia.test.service.ArticleService;

/**
 * @author tomar
 *
 */
@RestController
@RequestMapping("/api")
public class SpringAppController {

	private static Logger logger = LoggerFactory.getLogger(SpringAppController.class);

	@Autowired
	ArticleService articleService;

	/**
	 * This method is to save the new record.
	 * 
	 * @param articleRequest
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Article saveArticle(@RequestBody ArticleRequest articleRequest) {
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
		Article article = new Article();
		article.setTitle(articleRequest.getTitle());
		article.setBody(articleRequest.getBody());
		article.setSlug(articleRequest.getTitle().replaceAll(" ", "-"));
		article.setDescription(articleRequest.getDescription());
		article.setCreatedAt(timestamp);
		article.setUpdatedAt(timestamp);

		return articleService.save(article);
	}

	/**
	 * This method is to get the article based on slug
	 * 
	 * @param slug
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Article getArticle(@RequestBody String slug) {
		Optional<Article> article = articleService.findBySlug(slug);
		return article.isPresent() ? article.get() : null;
	}

	/**
	 * This method is to delete the article base on slug
	 * 
	 * @param slug
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public HeadersBuilder<?> deleteArticle(@RequestBody String slug) {
		long deletedCount = articleService.deleteBySlug(slug);
		logger.info("Total Row deleted :: " + deletedCount);
		return ResponseEntity.ok();
	}

	/**
	 * This method is to update and user has to pass Title as Slug to update the
	 * same where as title will not be updated but slug will
	 * 
	 * @param articleRequest
	 * @return
	 */
	/**
	 * @param articleRequest
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Article updateArticle(@RequestBody ArticleRequest articleRequest) {
		Optional<Article> articleOptional = articleService.findBySlug(articleRequest.getTitle().replaceAll(" ", "-"));
		Article article;
		if (articleOptional.isPresent()) {
			article = articleOptional.get();
		} else {
			article = new Article();
		}

		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
		article.setBody(articleRequest.getBody());
		article.setSlug(articleRequest.getTitle().replaceAll(" ", "-"));
		article.setDescription(articleRequest.getDescription());
		article.setCreatedAt(timestamp);
		article.setUpdatedAt(timestamp);

		return articleService.save(article);
	}
}
