package com.spring.professional.exam.tutorial.module05.question01.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module05.question01.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module05.question01.ds.Article;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class IndexControllerMockMvcFullTest {
	
	private static final Article ARTICLE_1 = Article.builder().id(1).title("Title-1").body("Body-1").build(); 
	private static final Article ARTICLE_2 = Article.builder().id(2).title("Title-2").body("Body-2").build(); 
	
	@Autowired private MockMvc mockMvc;
	
	@Autowired private ArticlesDao articlesDao;
	
	
	@Test
	public void shouldSaveArticleAndRedirectToIndex() throws Exception {
		
			
		mockMvc.perform(post("/save-article").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", "Title-1").param("body", "Body-1")
				.sessionAttr("newArticle", new Article()))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/"))
				.andExpect(redirectedUrl("/"));
		
		
		System.out.println(articlesDao.findById(1));		
		assertEquals(Optional.of(ARTICLE_1), articlesDao.findById(1));
	}
	
	@Test
	public void shouldDeleteArticleAndRedirect() throws Exception {
		articlesDao.save(ARTICLE_1);
		
		articlesDao.findAll().forEach(System.out::println);
		
		mockMvc.perform(post("/delete-article").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("id", "1"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/"))
				.andExpect(redirectedUrl("/"));
		
		System.out.println("After delete---");
		
		articlesDao.findAll().forEach(System.out::println);
		
		assertEquals(Optional.empty(), articlesDao.findById(1));
	}
	
	@Test
	public void shouldGetAllArticlesAndReturnIndex() throws Exception {
	
		articlesDao.saveAll(Arrays.asList(ARTICLE_1,ARTICLE_2));
		
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"))
		.andExpect(model().attribute("articles", hasSize(2)))
		.andExpect(model().attribute("articles", hasItem(
                allOf(
                        hasProperty("id", is(1)),
                        hasProperty("body", is("Body-1")),
                        hasProperty("title", is("Title-1"))
                )
        )))
        .andExpect(model().attribute("articles", hasItem(
                allOf(
                        hasProperty("id", is(2)),
                        hasProperty("body", is("Body-2")),
                        hasProperty("title", is("Title-2"))
                )
        )));
		
	}

}
