package com.namnd.store_procedure_example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author nam.nd
 * @created 27/09/2021 - 10:54 PM
 */

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private String age;

    private Long categoryId;
}
