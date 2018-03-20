package org.wecancodeit.ecom.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class CatalogJsonTest {

	@Autowired
	private JacksonTester<Product> json;

	@Test
	public void shouldSerialize() throws IOException {
		Product product = new Product("test");

		JsonContent<Product> content = json.write(product);

		assertThat(content).extractingJsonPathStringValue("@.name").isEqualTo("test");
	}

	@Test
	public void shouldDeserialize() throws IOException {
		String jsonContent = "{ \"name\": \"test\" }";

		Product result = json.parseObject(jsonContent);

		assertThat(result.getName()).isEqualTo("test");

	}

}