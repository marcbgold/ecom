const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (this.readyState === 4 && this.status === 200) {
		const res = JSON.parse(xhr.response)
		const container = document.createElement('div')
		container.innerText = res.name

		document.body.appendChild(container)
	}
}

xhr.open('GET', '/products/1000', true)
xhr.send()