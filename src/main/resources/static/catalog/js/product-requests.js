const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (this.readyState === 4 && this.status === 200) {
		const res = JSON.parse(xhr.response)
		const productsContainer = document.querySelector('#products-container')

		res.forEach((product) => {
			const productContainer = document.createElement('div')
			productContainer.innerText = product.name
			productsContainer.appendChild
			(productContainer)
		})
	}
}

xhr.open('GET', '/products', true)
xhr.send()
