package org.wecancodeit.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@RequestMapping("/products")
	public Collection<Product> findProducts() {
		return Collections.singleton(new Product("thing"));
	}

	@RequestMapping("/products/{id}")
	public Product findProduct(@PathVariable long id) {
		return new Product("thing");
	}

}
