package edjdc.portfolio.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import edjdc.portfolio.PortfolioApplication;
import edjdc.portfolio.model.Membro;
import edjdc.portfolio.repository.MembroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PortfolioApplication.class)
@WebAppConfiguration
public class MembroControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() throws Exception {
		mockMvc = webAppContextSetup(webApplicationContext).build();
		membroRepository.deleteAllInBatch();
	}
	
	@Test
	public void criarMembro() throws Exception {
		Membro membro = new Membro();
		membro.setNome("Edivilson José Dalacosta");
		membro.setCargo("Dev");
		
		mockMvc.perform(post("/membro")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(membro)))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void atualizarMembro() throws Exception {
		Membro membro = new Membro();
		membro.setNome("Edivilson José Dalacosta");
		membro.setCargo("Dev");
		
		membroRepository.save(membro);
		
		membro.setCargo("Engenheiro de software");
		
		mockMvc.perform(put("/membro")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(membro)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(membro.getId().intValue())));
		
		Membro findOne = membroRepository.findOne(membro.getId());
		assertThat(findOne.getCargo(), equalTo("Engenheiro de software"));
	}
	
	@Test
	public void deleteMembro() throws Exception {
		Membro membro = new Membro();
		membro.setNome("Edivilson José Dalacosta");
		membro.setCargo("Dev");
		
		membroRepository.save(membro);
		
		mockMvc.perform(delete("/membro/" + membro.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(membro)))
				.andExpect(status().isNoContent());
		
		boolean exists = membroRepository.exists(membro.getId());
		assertFalse(exists);
	}
	

	@Test
	public void getMembro() throws Exception {
		Membro membro = new Membro();
		membro.setNome("Edivilson José Dalacosta");
		membro.setCargo("Dev");
		
		membroRepository.save(membro);
		
		mockMvc.perform(get("/membro/" + membro.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(membro.getId().intValue())))
				.andExpect(jsonPath("$.nome", is(membro.getNome())))
				.andExpect(jsonPath("$.cargo", is(membro.getCargo())));
	}
	
}
