package com.bulbul.crud.util.builder;


import com.bulbul.crud.dto.EmployeeDTO;
import com.bulbul.crud.entity.Employee;
import java.util.Arrays;
import java.util.List;

public class EmployeeBuilder {

    public static List<EmployeeDTO> getListDTO() {
        return Arrays.asList(new EmployeeDTO(1L,"Basant","DEV",50000),
                new EmployeeDTO(2L,"Santosh","QA",80000));
    }

    public static List<Employee> getListEntities() {
        return Arrays.asList(new Employee(1L,"Basant","DEV",50000),
                new Employee(2L,"Santosh","QA",80000));
    }

    public static EmployeeDTO getDTO() {
        return new EmployeeDTO(1L,"Basant","DEV",50000);
    }

    public static Employee getEntity() {
        return new Employee(1L,"Basant","DEV",50000);
    }
}

