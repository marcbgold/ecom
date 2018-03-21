package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource
	CrudRepository<Product, Long> productRepo;

	@RequestMapping("/products")
	public Iterable<Product> findAllProducts() {
		return productRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product findOneProduct(@PathVariable long id) {
		Product selectedProduct = productRepo.findOne(id);
		if (selectedProduct != null) {
			return selectedProduct;
		}

		throw new ProductNotFoundException();
	}

	@SuppressWarnings("serial")
	public class ProductNotFoundException extends RuntimeException {
	}

}
