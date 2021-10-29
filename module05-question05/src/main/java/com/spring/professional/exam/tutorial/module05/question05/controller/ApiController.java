package com.spring.professional.exam.tutorial.module05.question05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.professional.exam.tutorial.module05.question05.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module05.question05.ds.Article;
import com.spring.professional.exam.tutorial.module05.question05.ds.ArticleCriteria;

@RestController
@RequestMapping(value = "/api/articles" , produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {
	
	@Autowired
	private ArticlesDao articlesDao;
	
	
	// curl localhost:8080/api/articles |jq
	@GetMapping
	public ResponseEntity<Iterable<Article>> listArticles(){
		return ResponseEntity.ok().body(articlesDao.findAll());
	}
	
	// curl -I localhost:8080/api/articles
	@RequestMapping(method = RequestMethod.HEAD)
	public ResponseEntity<Iterable<Article>> getArticlesCount(){
		return ResponseEntity.ok().header("Articles-Count", String.valueOf(articlesDao.count())).body(articlesDao.findAll());
	}
	
	// curl localhost:8080/api/articles/2	
	@GetMapping("{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable int id){
		return articlesDao.findById(id).map(ResponseEntity.ok()::body).orElse(ResponseEntity.notFound().build());
	}
	
	// curl -X POST localhost:8080/api/articles/search -H 'Content-Type: application/json' -d '{"bodyLike": "%some%"}'
	@PostMapping(value = "search",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Article>> searchByCriteria(@RequestBody ArticleCriteria articleCriteria){
		return ResponseEntity.ok().body(articlesDao.findByBodyLikeIgnoreCase(articleCriteria.getBodyLike()));
	}

	// curl -v -X PUT localhost:8080/api/articles -H 'Content-Type: application/json' -d '{"title": "New article", "body": "New article content"}'
	@PutMapping
	public ResponseEntity addArticle(@RequestBody Article article) {
		articlesDao.save(article);
		return ResponseEntity.ok().build();
	}
	
	// curl -v -X PATCH localhost:8080/api/articles/1 -H 'Content-Type: application/json' -d '{"title": "Updated article", "body": "Updated article content"}'
    @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateArticle(@PathVariable int id, @RequestBody Article article) {
        if (articlesDao.existsById(id)) {
            article.setId(id);
            articlesDao.save(article);

            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }

    // curl -v -X DELETE localhost:8080/api/articles/3
    @DeleteMapping("{id}")
    public ResponseEntity deleteArticleById(@PathVariable int id) {
        if (articlesDao.existsById(id)) {
            articlesDao.deleteById(id);

            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
