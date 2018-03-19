package org.wecancodeit.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

public class BrowseController {

	public Collection<Product> getProducts() {
		return Collections.singleton(new Product());
	}

}
