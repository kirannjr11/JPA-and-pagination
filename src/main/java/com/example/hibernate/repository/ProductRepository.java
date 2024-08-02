package com.example.hibernate.repository;

import com.example.hibernate.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
//    List<ProductEntity> findQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);
    List<ProductEntity> findByTitleLike(String title);

}
