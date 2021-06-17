package org.serratec.backend.padaria.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.padaria.models.ProductEntity;
import org.serratec.backend.padaria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<ProductEntity> getAll() {
		return this.productRepository.findAll();
	}

	public Optional<ProductEntity> getById(Long id) {
		return productRepository.findById(id);
	}

	public ProductEntity create(ProductEntity product) {
		return this.productRepository.save(product);
	}

	public ProductEntity update(Long id, ProductEntity product) {
		ProductEntity entity = productRepository.getById(id);
		entity = product;
		
		return this.productRepository.save(entity);
	}

	public void delete(Long id) {

		productRepository.deleteById(id);
	}
}
