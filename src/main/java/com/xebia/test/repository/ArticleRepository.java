/**
 * 
 */
package com.xebia.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.test.model.Article;

/**
 * @author tomar
 *
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	Article save(Article persisted);
	
	Optional<Article> findBySlug(String slug);
	
	long deleteBySlug(String slug);
		
}
