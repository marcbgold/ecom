package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

public class MaintenanceController {

	@Resource
	CrudRepository<Product, Long> productRepo;

	@RequestMapping("/products")
	public Iterable<Product> findAllProducts() {
		return productRepo.findAll();
	}

}
