package com.spring.professional.exam.tutorial.module05.question05.test39;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureJsonTesters
public class ApiControllerRestTemplateTest {
	
	public static final Article ASSERTION_ARTICLE_1 = new Article(1, "Article-1", "Article content-1");
	public static final Article ASSERTION_ARTICLE_2 = new Article(2, "Article-2", "Article content-2");
	
	public static final Article ASSERTION_ARTICLE_3 = new Article(3, "Article-3", "Article content-3");
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private JacksonTester<Article> json;
	
	@Test
	public void shoudSaveArticles() {
		String url = String.format("http://localhost:%d/api/articles", port);
		restTemplate.put(url, Article.builder().title("Article-1").body("Article content-1").build());
		restTemplate.put(url, Article.builder().title("Article-2").body("Article content-2").build());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Article> entity = new HttpEntity<Article>(new Article(), headers);
		ResponseEntity<Iterable<Article>> response =  restTemplate.exchange("/api/articles",HttpMethod.GET,entity, new ParameterizedTypeReference<Iterable<Article>>() {} );
		
		System.out.println(response.getBody());
		assertThat(response.getBody()).contains(ASSERTION_ARTICLE_1).contains(ASSERTION_ARTICLE_2);
		//.contains(ASSERTION_ARTICLE_3);
		
		//assertThat(articles.getArticles()).containsOnly(ASSERTION_ARTICLE_1,ASSERTION_ARTICLE_2);
	}

}
