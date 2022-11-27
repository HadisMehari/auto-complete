package com.bofa.autocomplete.repository;

import com.bofa.autocomplete.domain.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value="select TOP :pageSize c.description from Company c where c.description like :keyword%", nativeQuery=true)
    List<String> search(@Param("keyword") String keyword, @Param("pageSize") int pageSize);
}
