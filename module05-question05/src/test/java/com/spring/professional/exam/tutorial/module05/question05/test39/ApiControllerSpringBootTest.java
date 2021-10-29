package com.spring.professional.exam.tutorial.module05.question05.test39;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.professional.exam.tutorial.module05.question05.controller.ApiController;
import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@SpringBootTest
public class ApiControllerSpringBootTest {

	public static final Article ASSERTION_ARTICLE_1 = new Article(1, "Article-1", "Article content-1");
	public static final Article ASSERTION_ARTICLE_2 = new Article(2, "Article-2", "Article content-2");
	public static final Article ASSERTION_ARTICLE_3 = new Article(3, "Article-3", "Article content-3");
	
	@Autowired
	private ApiController apiController;
	
	@Test
	public void shouldSaveArticles() {
		
		apiController.addArticle(Article.builder().title("Article-1").body("Article content-1").build());
		apiController.addArticle(Article.builder().title("Article-2").body("Article content-2").build());
		
		assertThat(apiController.listArticles().getBody()).contains(ASSERTION_ARTICLE_1).contains(ASSERTION_ARTICLE_2);
	}
	
}
