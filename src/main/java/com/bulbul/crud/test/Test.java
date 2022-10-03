package com.bulbul.crud.test;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "test")
public class Test {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not be blank")
    private String name;

    private String dept;

}
