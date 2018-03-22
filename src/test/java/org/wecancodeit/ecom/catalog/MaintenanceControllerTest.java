package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;

public class MaintenanceControllerTest {

	@InjectMocks
	MaintenanceController underTest;

	@Mock
	private CrudRepository<Product, Long> productRepo;

	@Mock
	private Product incomingProduct;

	@Mock
	private Product persistentProduct;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCreateNewProduct() {
		when(productRepo.save(incomingProduct)).thenReturn(persistentProduct);

		Product result = underTest.addNewProduct(incomingProduct);

		assertThat(result, is(persistentProduct));
	}

}
