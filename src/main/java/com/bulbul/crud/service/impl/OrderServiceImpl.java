package com.bulbul.crud.service.impl;

import com.bulbul.crud.dao.OrderRepository;
import com.bulbul.crud.entity.Order;
import com.bulbul.crud.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order entity) {
        return repository.save(entity);
    }

    @Override
    public List<Order> save(List<Order> entities) {
        return (List<Order>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) repository.findAll();
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        Page<Order> entityPage = repository.findAll(pageable);
        List<Order> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Order update(Order entity, Long id) {
        Optional<Order> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}