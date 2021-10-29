package com.spring.professional.exam.tutorial.module05.question05.test39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.spring.professional.exam.tutorial.module05.question05.controller.ApiController;
import com.spring.professional.exam.tutorial.module05.question05.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@SpringBootTest(classes = ApiController.class)
public class ApiControllerSmallSpringBootTest {
	
	public static final Article ARTICLE_1 = new Article(null, "Article-1", "Article content-1");
	public static final Article ARTICLE_2 = new Article(null, "Article-2", "Article content-2");
	
	
	public static final Article ASSERTION_ARTICLE_1 = new Article(1, "Article-1", "Article content-1");
	public static final Article ASSERTION_ARTICLE_2 = new Article(2, "Article-2", "Article content-2");
	public static final Article ASSERTION_ARTICLE_3 = new Article(3, "Article-3", "Article content-3");
	
	@Autowired
	private ApiController apiController;
	
	@MockBean 
	private ArticlesDao articlesDao;
	
	@Test
	public void shouldSaveFewArticles() {
		
		apiController.addArticle(Article.builder().title("Article-1").body("Article content-1").build());
		apiController.addArticle(Article.builder().title("Article-2").body("Article content-2").build());
		
		verify(articlesDao,times(1)).save(ARTICLE_1);
		verify(articlesDao,times(1)).save(ARTICLE_2);
		
	}
	
	@Test
	public void shouldFetchArticles() {
		when(articlesDao.findAll()).thenReturn(Arrays.asList(ASSERTION_ARTICLE_1,ASSERTION_ARTICLE_2));
		
		ResponseEntity<Iterable<Article>> resrponse =   apiController.listArticles();
		
		assertThat(resrponse.getBody()).contains(ASSERTION_ARTICLE_1).contains(ASSERTION_ARTICLE_2);
	}
	

}
