package com.spring.professional.exam.tutorial.module05.question01.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.spring.professional.exam.tutorial.module05.question01.ds.Article;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ArticleDaoTest {

	private static final Article ARTICLE_1 = new Article(1, "Test-1", "Desc-1");
	private static final Article ARTICLE_2 = new Article(2, "Test-2", "Desc-2");
	private static final Article ARTICLE_3 = new Article(3, "Test-3", "Desc-3");
	
	@Autowired private ArticlesDao articlesDao;
	@Autowired private TestEntityManager testEntityManager;
	
	
	@Test 
	public void shouldStoreArticle() {
		articlesDao.saveAll(Arrays.asList(ARTICLE_1,ARTICLE_2));
		
		articlesDao.findAll().forEach(System.out::println);
		
		assertEquals(ARTICLE_1, testEntityManager.find(Article.class, 1));
		assertEquals(ARTICLE_2, testEntityManager.find(Article.class, 2));
		testEntityManager.clear();
		
	}
	
	@Test
	public void shouldFindArticleByTitle() {
		
		articlesDao.findAll().forEach(System.out::println);
		testEntityManager.merge(ARTICLE_1);	
		testEntityManager.merge(ARTICLE_2);
		testEntityManager.merge(ARTICLE_3);
		
		articlesDao.findAll().forEach(System.out::println);
		
		System.out.println("Article-1 "+articlesDao.findByTitle("Test-1"));
		
		assertEquals(ARTICLE_1,articlesDao.findByTitle(ARTICLE_1.getTitle()) );
		assertEquals(ARTICLE_2, articlesDao.findByTitle(ARTICLE_2.getTitle()));		
		assertEquals(ARTICLE_3, articlesDao.findByTitle("Test-3"));
	}
}
