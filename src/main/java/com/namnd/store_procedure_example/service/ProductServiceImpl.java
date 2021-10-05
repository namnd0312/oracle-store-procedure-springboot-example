package com.namnd.store_procedure_example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.namnd.store_procedure_example.dto.ProductDto;
import oracle.jdbc.OracleTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nam.nd
 * @created 15/09/2021 - 12:19 AM
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private EntityManager em;

//    String dbURL = "jdbc:oracle:thin:@localhost:1521:SHOPMALL";
//    String user = "hr";
//    String password = "123456";

    @Override
    public List<ProductDto> selectStore() throws SQLException {
    	  List<ProductDto> result = new ArrayList<>();
        try {
          
            EntityManagerFactoryInfo factory = (EntityManagerFactoryInfo) em.getEntityManagerFactory();
            Connection connection = factory.getDataSource().getConnection();

            String query = "{call HR.get_all_product(?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.registerOutParameter(1, OracleTypes.CURSOR);
            statement.setInt(2, 12);
            statement.executeQuery();

            ResultSet rs = (ResultSet) statement.getObject(1);
            while (rs.next()) {

                ProductDto productDto = new ProductDto();
                productDto.setName(rs.getString("name"));
                productDto.setAge(rs.getString("age"));
                productDto.setCategoryId(rs.getLong("category_id"));
                result.add(productDto);
                ObjectMapper mapper = new ObjectMapper();
                log.info(mapper.writeValueAsString(productDto));
            }
            
            rs.close();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;


    }
}
