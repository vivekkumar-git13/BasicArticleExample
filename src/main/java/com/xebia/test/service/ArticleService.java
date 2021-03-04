/**
 * 
 */
package com.xebia.test.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xebia.test.model.Article;
import com.xebia.test.repository.ArticleRepository;

/**
 * @author tomar
 *
 */
@Component
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	public Article save(Article article) {
		return articleRepository.save(article);
	}

	public Optional<Article> findBySlug(String slug) {
		return articleRepository.findBySlug(slug);
	}

	@Transactional
	public long deleteBySlug(String slug) {
		return articleRepository.deleteBySlug(slug);
	}
}
