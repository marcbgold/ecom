package org.wecancodeit.ecom.catalog;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(MaintenanceController.class)
public class MaintenanceMvcTest {

	@Resource
	private MockMvc mvc;

	@Resource
	private ObjectMapper jsonMapper;

	// @MockBean
	// private CrudRepository<Product, Long> productRepo;

	@Test
	public void shouldCreateOneProduct() throws Exception {
		Product product = new Product("test");
		String productJson = jsonMapper.writeValueAsString(product);
		mvc.perform(post("/products").content(productJson)).andExpect(status().isOk());
	}

	// @Test
	// public void shouldRetrieveOneProduct() throws Exception {
	// when(productRepo.findOne(1L)).thenReturn(new Product("test"));
	//
	// mvc.perform(get("/products/1")).andExpect(status().isOk());
	// }
	//
	// @Test
	// public void shouldReturnNotFoundForBadProductId() throws Exception {
	// mvc.perform(get("/products/1")).andExpect(status().isNotFound());
	// }

}
