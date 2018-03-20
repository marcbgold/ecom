package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;

public class BrowseControllerTest {

	@InjectMocks
	BrowseController underTest;

	@Mock
	private CrudRepository<Product, Long> productRepo;

	@Mock
	private Product product;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetAllProducts() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));

		Iterable<Product> result = underTest.findProducts();

		assertThat(result, contains(any(Product.class)));
	}

	@Test
	public void shouldGetAllProductsFromDatabase() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));

		Iterable<Product> result = underTest.findProducts();

		assertThat(result, contains(product));
	}

	@Test
	public void shouldGetOneProduct() {
		Product result = underTest.findProduct(1L);

		assertThat(result, is(not(nullValue())));
	}

}
