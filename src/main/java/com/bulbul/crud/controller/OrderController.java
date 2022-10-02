package com.bulbul.crud.controller;

import com.bulbul.crud.dto.OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Order API")
public interface OrderController {
    @ApiOperation("Add new data")
    public OrderDTO save(@RequestBody OrderDTO order);

    @ApiOperation("Find by Id")
    public OrderDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<OrderDTO> list();

    @ApiOperation("Pagination request")
    public Page<OrderDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public OrderDTO update(@RequestBody OrderDTO dto, @PathVariable("id") Long id);
}