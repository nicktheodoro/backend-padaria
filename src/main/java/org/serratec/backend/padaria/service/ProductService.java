package org.serratec.backend.padaria.service;

import java.util.List;

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

	public ProductEntity create(ProductEntity product) {
		return this.productRepository.save(product);
	}

	public ProductEntity update(Long id, ProductEntity product) {
		ProductEntity entity = productRepository.getById(id);

		product.setNome(product.getNome());
		product.setQuantidade(product.getQuantidade());
		product.setValor(product.getValor());
		product.setUrlImagem(product.getUrlImagem());

		return productRepository.save(entity);
	}

	public void delete(Long id) {

		productRepository.deleteById(id);
	}
}
