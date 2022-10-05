package com.bulbul.crud.controller.impl;

import com.bulbul.crud.dto.EmployeeDTO;
import com.bulbul.crud.controller.EmployeeController;
import com.bulbul.crud.entity.Employee;
import com.bulbul.crud.mapper.EmployeeMapper;
import com.bulbul.crud.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/employee")
@RestController
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeControllerImpl(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.save(employee));
    }

    @Override
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id).orElse(null);
        return employeeMapper.asDTO(employee);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<EmployeeDTO> list() {
        return employeeMapper.asDTOList(employeeService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<EmployeeDTO> pageQuery(Pageable pageable) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        List<EmployeeDTO> dtoList = employeePage
                .stream()
                .map(employeeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, employeePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Long id) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.update(employee, id));
    }
}