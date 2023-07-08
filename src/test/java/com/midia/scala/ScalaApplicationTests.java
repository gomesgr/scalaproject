package com.midia.scala;

import com.google.gson.Gson;
import com.midia.scala.funcao.Funcao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
public class ScalaApplicationTests {
	private MockMvc mvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation))
				.alwaysDo(document("{testes-crud}"))
				.build();
	}

//	@Test
	public void contextLoads() throws Exception {
		this.mvc.perform(get("/api/membro")
						.accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk()).andDo(document("index"));
	}

	@Test
	public void createFuncao() throws Exception {
		Funcao f = new Funcao("Pregador");
		Gson gson = new Gson();
		this.mvc.perform(post("/api/funcao/test")
				.content(gson.toJson(f))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andDo(document("funcao/criar"));
	}

	@Test
	public void accessMainPage() throws Exception {
		this.mvc.perform(get("/")
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isNotFound())
						.andDo(document("index",
							links(linkWithRel("Página Inicial").description("Link para a primeira página dando *404*"))));

	}

}
