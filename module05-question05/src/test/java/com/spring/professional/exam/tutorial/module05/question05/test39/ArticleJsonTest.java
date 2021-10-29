package com.spring.professional.exam.tutorial.module05.question05.test39;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@JsonTest
public class ArticleJsonTest {

	public static final Article ASSERTION_ARTICLE_1 = new Article(1, "Article-1", "Article content-1");
	public static final Article ASSERTION_ARTICLE_2 = new Article(2, "Article-2", "Article content-2");
	
	@Autowired
	private JacksonTester<Article> json;
	
	@Test
	public void shouldserialize() throws IOException {
		String jsonArticle  = json.write(ASSERTION_ARTICLE_1).getJson();
		assertEquals(jsonArticle, "{\"id\":1,\"title\":\"Article-1\",\"body\":\"Article content-1\"}");
	}
	
	@Test
	public void shouldDeserialize() throws IOException {
		Article article = json.parse("{\"id\":1,\"title\":\"Article-1\",\"body\":\"Article content-1\"}").getObject();
		
		assertEquals(Integer.valueOf(1), article.getId());
		assertEquals("Article-1", article.getTitle());
		assertEquals("Article content-1", article.getBody());
	}
	
}



