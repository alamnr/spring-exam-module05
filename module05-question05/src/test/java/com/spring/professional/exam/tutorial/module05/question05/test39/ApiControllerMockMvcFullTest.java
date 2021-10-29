package com.spring.professional.exam.tutorial.module05.question05.test39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ApiControllerMockMvcFullTest {

	public static final Article ARTICLE_1 = new Article(null, "Article-1", "Article content-1");
	public static final Article ARTICLE_2 = new Article(null, "Article-2", "Article content-2");
	
	public static final Article ASSERTION_ARTICLE_1 = new Article(1, "Article-1", "Article content-1");
	public static final Article ASSERTION_ARTICLE_2 = new Article(2, "Article-2", "Article content-2");
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private JacksonTester<Article> json;
	
	
	@Test
	public void shouldSaveArticles() throws Exception {
		
		String articleJson_1 = json.write(ARTICLE_1).getJson();
		String articleJson_2 = json.write(ARTICLE_2).getJson();
		
		System.out.println(articleJson_1);
		
		mockMvc.perform(put("/api/articles").content(articleJson_1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		mockMvc.perform(put("/api/articles").content(articleJson_2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		String jsonResponse = mockMvc.perform(get("/api/articles")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		//System.out.println(jsonResponse);
		
		
		
		assertThat(jsonResponse).contains("{\"id\":1,\"title\":\"Article-1\",\"body\":\"Article content-1\"}")
		.contains("\"id\":2,\"title\":\"Article-2\",\"body\":\"Article content-2\"");
	}
	
	@Test
	public void shouldTestHeadMethodForArticlesCount() throws Exception {
		
		String articleJson_1 = json.write(ARTICLE_1).getJson();
		String articleJson_2 = json.write(ARTICLE_2).getJson();
		
		mockMvc.perform(put("/api/articles").content(articleJson_1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		mockMvc.perform(put("/api/articles").content(articleJson_2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		String header = mockMvc.perform(head("/api/articles")).andExpect(status().isOk()).andReturn()
				.getResponse().getHeader("Articles-Count");
		
		assertEquals(header,String.valueOf( 2));
		
		
	}
	
	@Test
	public void shouldFindArticleById() throws Exception {
		String articleJson_1 = json.write(ARTICLE_1).getJson();
		String articleJson_2  =  json.write(ARTICLE_2).getJson();
		
		mockMvc.perform(put("/api/articles/").content(articleJson_1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		mockMvc.perform(put("/api/articles/").content(articleJson_2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		String jsonResponse = mockMvc.perform(get("/api/articles/1"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertThat(jsonResponse).contains("{\"id\":1,\"title\":\"Article-1\",\"body\":\"Article content-1\"}");
	}
	
	@Test
	public void shouldSearchByCriteria() throws Exception {
		
		String articleJson_1 = json.write(ARTICLE_1).getJson();
		String articleJson_2 = json.write(ARTICLE_2).getJson();
		
		mockMvc.perform(put("/api/articles/").content(articleJson_1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		mockMvc.perform(put("/api/articles/").content(articleJson_2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		String jsonResponse = mockMvc.perform(post("/api/articles/search").content("{\"bodyLike\":\"%content-1%\"}")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		
		assertThat(jsonResponse).contains(json.write(ASSERTION_ARTICLE_1).getJson());
		//.contains(json.write(ASSERTION_ARTICLE_2).getJson());
		
	}
	
	@Test
	public void shouldUpdateArticle() throws Exception {
		
		String articleJson_1 = json.write(ARTICLE_1).getJson();
		String articleJson_2  = json.write(ARTICLE_2).getJson();
		
		mockMvc.perform(put("/api/articles").content(articleJson_1).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		mockMvc.perform(put("/api/articles").content(articleJson_2).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		 mockMvc.perform(patch("/api/articles/2")
				.content("{\"title\":\"Updated Title\",\"body\":\"updated body\"}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		mockMvc.perform(get("/api/articles/2"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.title", is("Updated Title")))
				.andExpect(jsonPath("$.body", is("updated body")));
		
		
		
	}
	
	@Test
	public void shouldDeleteArticle() throws Exception {
		String articleJson_1 = json.write(ARTICLE_1).getJson();
		String articleJson_2  = json.write(ARTICLE_2).getJson();
		
		mockMvc.perform(put("/api/articles").content(articleJson_1).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		mockMvc.perform(put("/api/articles").content(articleJson_2).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		mockMvc.perform(delete("/api/articles/2")).andExpect(status().isOk());
		mockMvc.perform(delete("/api/articles/5")).andExpect(status().isNotFound());
		
	}
}
