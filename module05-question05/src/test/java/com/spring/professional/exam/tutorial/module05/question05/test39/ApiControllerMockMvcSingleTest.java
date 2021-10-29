package com.spring.professional.exam.tutorial.module05.question05.test39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.professional.exam.tutorial.module05.question05.controller.ApiController;
import com.spring.professional.exam.tutorial.module05.question05.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module05.question05.ds.Article;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiController.class)
@AutoConfigureJsonTesters
public class ApiControllerMockMvcSingleTest {
	
	public static final Article ARTICLE_1 = new Article(null, "Article-1", "Article content-1");
	public static final Article ARTICLE_2 = new Article(null, "Article-2", "Article content-2");
	
	public static final Article ASSERTION_ARTICLE_1 = new Article(1, "Article-1", "Article content-1");
	public static final Article ASSERTION_ARTICLE_2 = new Article(2, "Article-2", "Article content-2");
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private JacksonTester<Article> json;
	
	@MockBean
	private ArticlesDao articlesDao;

	@Test
	public void shouldSaveArticle() throws Exception {
		
		mockMvc.perform(put("/api/articles/").content("{\"title\":\"Article-1\",\"body\":\"Article content-1\"}")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		verify(articlesDao,times(1)).save(ARTICLE_1);
		
	}
	
	@Test
	public void shouldFetchArticles() throws Exception {
		when(articlesDao.findAll()).thenReturn(Arrays.asList(ASSERTION_ARTICLE_1,ASSERTION_ARTICLE_2));
		
		String jsonResponse = mockMvc.perform(get("/api/articles")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
				/*.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.title", is("Article-1")))
				.andExpect(jsonPath("$.body", is("Article content-1")));*/
		
		String articleJson_2 = json.write(ASSERTION_ARTICLE_2).getJson(); 
		
		assertThat(jsonResponse).contains("{\"id\":1,\"title\":\"Article-1\",\"body\":\"Article content-1\"}")
			.contains(articleJson_2);
		
	}
}
