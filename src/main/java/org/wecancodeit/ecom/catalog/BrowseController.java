package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource
	CrudRepository<Product, Long> productRepo;

	@RequestMapping(path = "/products", method = RequestMethod.GET)
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
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProductNotFoundException extends RuntimeException {

	}

}
