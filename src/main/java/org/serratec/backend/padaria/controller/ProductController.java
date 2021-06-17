package org.serratec.backend.padaria.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.padaria.models.ProductEntity;
import org.serratec.backend.padaria.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAll() {
		List<ProductEntity> list = productService.getAll();
		return  new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProductEntity>> getById(@PathVariable Long id) {
		Optional<ProductEntity> product = productService.getById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity produto) {
		ProductEntity product = productService.create(produto);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductEntity> update(@PathVariable Long id, @RequestBody ProductEntity product) {
		ProductEntity updateProduct = productService.update(id, product);
		return new ResponseEntity<>(updateProduct, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductEntity> delete(@PathVariable Long id) {
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
