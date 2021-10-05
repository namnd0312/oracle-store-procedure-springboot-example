package com.namnd.store_procedure_example.service;

import java.sql.SQLException;
import java.util.List;

import com.namnd.store_procedure_example.dto.ProductDto;

/**
 * @author nam.nd
 * @created 15/09/2021 - 12:19 AM
 */
public interface ProductService {

    List<ProductDto>selectStore() throws SQLException;
}
