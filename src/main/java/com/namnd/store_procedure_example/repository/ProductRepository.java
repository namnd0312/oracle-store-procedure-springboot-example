package com.namnd.store_procedure_example.repository;

import com.namnd.store_procedure_example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 15/09/2021 - 12:18 AM
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
