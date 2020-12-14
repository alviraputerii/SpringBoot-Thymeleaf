package com.vr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vr.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value = "select * from customer.customer_tbl where firstname like CONCAT('%',:keyword,'%') or lastname like CONCAT('%',:keyword,'%')", nativeQuery = true)
	List<Customer> findByKeyword(@Param("keyword") String keyword);
}
