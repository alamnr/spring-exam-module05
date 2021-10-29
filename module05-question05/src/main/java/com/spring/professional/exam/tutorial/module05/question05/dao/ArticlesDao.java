package com.spring.professional.exam.tutorial.module05.question05.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

public interface ArticlesDao extends CrudRepository<Article, Integer> {

	List<Article> findByBodyLikeIgnoreCase(String content);
}
