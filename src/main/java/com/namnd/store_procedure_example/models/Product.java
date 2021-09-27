package com.namnd.store_procedure_example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 15/09/2021 - 12:04 AM
 */

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String age;

    private Long categoryId;
}
