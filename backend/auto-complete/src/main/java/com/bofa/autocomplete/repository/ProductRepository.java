package com.bofa.autocomplete.repository;

import com.bofa.autocomplete.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value="select p.description from Product p where p.description like :keyword% limit :page", nativeQuery=true)
    List<String> search(@Param("keyword") String keyword, int page);
}
