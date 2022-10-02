package com.bulbul.crud.util.builder;

import com.bulbul.crud.employee.dto.OrderDTO;
import com.bulbul.crud.employee.entity.Order;

import java.util.Arrays;
import java.util.List;

public class OrderBuilder {
    public static List<OrderDTO> getListDTO() {

        return Arrays.asList(new OrderDTO(1L,"Order1","Order1 Description",EmployeeBuilder.getEntity()),
                new OrderDTO(2L,"Order2","Order2 Description",EmployeeBuilder.getEntity()));
    }

    public static List<Order> getListEntities() {
        return Arrays.asList(new Order(1L,"Order1","Order1 Description",EmployeeBuilder.getEntity()),
                new Order(2L,"Order2","Order2 Description",EmployeeBuilder.getEntity()));
    }

    public static OrderDTO getDTO() {
        return new OrderDTO(1L,"Order1","Order1 Description",EmployeeBuilder.getEntity());
    }

    public static Order getEntity() {
        return new Order(1L,"Order1","Order1 Description",EmployeeBuilder.getEntity());
    }
}
