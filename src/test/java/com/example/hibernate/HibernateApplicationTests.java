package com.example.hibernate;

import com.example.hibernate.entities.ProductEntity;
import com.example.hibernate.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class HibernateApplicationTests {
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testRepository() {
//		ProductEntity productEntity = ProductEntity.builder()
//				.sku("waiwaui")
//				.title("chocolate")
//				.price(BigDecimal.valueOf(123.45))
//				.quantity(12)
//				.build();
//		ProductEntity savedProductEntity = productRepository.save(productEntity);
//		System.out.println(savedProductEntity);
//	}

	@Test
	void getRepository() {
		List<ProductEntity> entities = productRepository.findAll();
		System.out.println(entities);
	}

	@Test
	void getByTitile() {
		List<ProductEntity> entities = productRepository.findByTitle("chocolate");
		System.out.println(entities);
	}

	@Test
	void getById() {
		Optional<ProductEntity> optionalEntity = productRepository.findById(28L);
		if (optionalEntity.isPresent()) {
			ProductEntity entity = optionalEntity.get();
			System.out.println(entity);
		} else {
			System.out.println("Product not found");
		}
	}

	@Test
	void getByAfter() {
		LocalDateTime date = LocalDateTime.of(2024, 7, 31, 0, 0);
		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(date);
//		if (!entities.isEmpty()) {
//			entities.forEach(System.out::println);
//		} else {
//			System.out.println("Products not found");
//		}
		if(!entities.isEmpty()) {
			System.out.println(entities);
		} else {
			System.out.println("resource not found");
		}
	}

	@Test
	void getTitleLike() {
		List<ProductEntity> entities = productRepository.findByTitleLike("%Ch%");
		System.out.println(entities);
	}
}
