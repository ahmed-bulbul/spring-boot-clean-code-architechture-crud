package com.bulbul.crud.dto;

import com.bulbul.crud.entity.Employee;

public class OrderDTO {
    private Long id;
    private String orderName;
    private String orderDescription;
    private Employee employee;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String orderName, String orderDescription, Employee employee) {
        this.id = id;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.employee = employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return this.orderName;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderDescription() {
        return this.orderDescription;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}