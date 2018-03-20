package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class BrowseControllerTest {

	BrowseController underTest;

	@Before
	public void setup() {
		underTest = new BrowseController();
	}

	@Test
	public void shouldGetAllProducts() {
		Collection<Product> result = underTest.findProducts();

		assertThat(result, hasSize(greaterThan(0)));
	}

	@Test
	public void shouldGetOneProduct() {
		Product result = underTest.findProduct(1L);

		assertThat(result, is(not(nullValue())));
	}

}
