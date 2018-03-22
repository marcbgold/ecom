package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {

	@Resource
	CrudRepository<Product, Long> productRepo;

	@RequestMapping("/products")
	public Product addNewProduct(Product product) {
		return productRepo.save(product);
	}

}
