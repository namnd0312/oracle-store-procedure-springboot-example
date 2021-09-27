package com.namnd.store_procedure_example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 19/09/2021 - 4:13 PM
 */

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categoryName;
}
