package com.spring.professional.exam.tutorial.module05.question01.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module05.question01.ds.Article;

public interface ArticlesDao extends CrudRepository<Article, Integer> {
	Article findByTitle(String name);
}
