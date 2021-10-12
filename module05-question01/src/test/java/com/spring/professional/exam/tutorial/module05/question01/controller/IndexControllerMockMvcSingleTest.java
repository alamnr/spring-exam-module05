package com.spring.professional.exam.tutorial.module05.question01.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class IndexControllerMockMvcSingleTest {
	
	private static final Article ARTICLE_1 = Article.builder().id(1).title("Title-1").body("Body-1").build(); 
	private static final Article ARTICLE_2 = Article.builder().id(2).title("Title-2").body("Body-2").build(); 
	
	@Autowired private MockMvc mockMvc;
	
	@MockBean private ArticlesDao articlesDao;
	
	@Test
	public void shouldSaveArticleAndRedirectToIndex() throws Exception {
		
		
		mockMvc.perform(post("/save-article").contentType(MediaType.APPLICATION_FORM_URLENCODED)
							.param("title", "Title-1").param("body", "Body-1")
							.sessionAttr("newArticle", new Article()))
							.andExpect(status().is3xxRedirection())
							.andExpect(view().name("redirect:/"))
							.andExpect(redirectedUrl("/"));
		
		ArgumentCaptor<Article> formObjectArgument = ArgumentCaptor.forClass(Article.class);
		
		//verify(articlesDao,times(1)).save(new Article(null, "Title-1", "Body-1"));
		verify(articlesDao,times(1)).save(formObjectArgument.capture());
		verifyNoMoreInteractions(articlesDao);
		
		Article formObject = formObjectArgument.getValue();
		
		assertThat(formObject.getBody(),is("Body-1"));
		assertNull(formObject.getId());
		assertThat(formObject.getTitle(),is("Title-1"));
		
		
	}
	
	@Test
	public void shouldDeleteArticleAndRedirect() throws Exception {
	
		mockMvc.perform(post("/delete-article").contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("id", "1"))
					.andExpect(status().is3xxRedirection())
					.andExpect(view().name("redirect:/"))
					.andExpect(redirectedUrl("/"));
		
		verify(articlesDao,times(1)).deleteById(1);
		
		
	}
	
	@Test
	public void shouldGetAllArticlesAndReturnIndex() throws Exception {
		
		
		when(articlesDao.findAll()).thenReturn(Arrays.asList(ARTICLE_1,ARTICLE_2));
		
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
		verify(articlesDao,times(1)).findAll();
		verifyNoMoreInteractions(articlesDao);
		
	}

}
