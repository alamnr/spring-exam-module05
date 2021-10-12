package com.spring.professional.exam.tutorial.module05.question01.entitiy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.professional.exam.tutorial.module05.question01.ds.Article;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ArticleTest {
	
	private static final Article ARTICLE_1 = new Article(1, "Test-1", "Desc-1");
	private static final Article ARTiCLE_2 = new Article(2, "Test-2", "Desc-2");
	
	@Autowired private TestEntityManager testEntityManager;
	
	@Test
	public void shouldSaveArticleAndFindById() {
		testEntityManager.merge(ARTICLE_1);
		testEntityManager.merge(ARTiCLE_2);
		
		assertEquals(ARTICLE_1, testEntityManager.find(Article.class, 1));
		assertEquals(ARTiCLE_2, testEntityManager.find(Article.class, 2));
	}

}
