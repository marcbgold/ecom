package org.wecancodeit.ecom.catalog;

//@Component
public class Product {

	private String name;

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
