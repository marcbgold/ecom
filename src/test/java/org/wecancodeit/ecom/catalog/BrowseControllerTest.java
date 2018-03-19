package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class BrowseControllerTest {

	@Test
	public void shouldGetProducts() {
		BrowseController underTest = new BrowseController();

		Collection<Product> result = underTest.getProducts();

		assertThat(result, hasSize(greaterThan(0)));
	}

}
