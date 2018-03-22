package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CatalogJpaMappingsTest {

	// @Resource
	// private TestEntityManager entityManager;

	@Resource
	private CrudRepository<Product, Long> productRepo;

	// private static final Date REV_DATE = new Date();

	@Before
	public void setup() {
	}

	@Test
	public void shouldInitializeProductRepository() {
	}

	@Test
	public void shouldAssignIdToNewProduct() {
		Product product = new Product("test");

		product = productRepo.save(product);

		assertThat(product.getId(), is(greaterThan(0L)));
	}

	// @Test
	// public void shouldEstablishManyReviewsToOneCategoryRelationship() {
	// category = categoryRepo.save(category);
	// long categoryId = category.getId();
	//
	// firstReview = reviewRepo.save(firstReview);
	// secondReview = reviewRepo.save(secondReview);
	//
	// entityManager.flush();
	// entityManager.clear();
	//
	// category = categoryRepo.findOne(categoryId);
	// assertThat(category.getReviews(), containsInAnyOrder(firstReview,
	// secondReview));
	// }
}