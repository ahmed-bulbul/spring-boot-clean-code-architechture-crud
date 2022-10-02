package com.bulbul.crud.employee.mapper;

import com.bulbul.crud.employee.dto.OrderDTO;
import com.bulbul.crud.employee.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Order asEntity(OrderDTO dto);
}