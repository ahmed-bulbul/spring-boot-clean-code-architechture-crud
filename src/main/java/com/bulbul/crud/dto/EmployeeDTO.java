package com.bulbul.crud.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String dept;

    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return this.dept;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }
}