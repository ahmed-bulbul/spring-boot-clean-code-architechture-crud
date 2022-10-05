package com.bulbul.crud.controller;

import com.bulbul.crud.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "User API")
public interface UserController {
    @ApiOperation("Add new data")
    public UserDTO save(@RequestBody UserDTO user);

    @ApiOperation("Find by Id")
    public UserDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<UserDTO> list();

    @ApiOperation("Pagination request")
    public Page<UserDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public UserDTO update(@RequestBody UserDTO dto, @PathVariable("id") Long id);
}