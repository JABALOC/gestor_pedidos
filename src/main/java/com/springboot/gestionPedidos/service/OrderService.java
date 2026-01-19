package com.springboot.gestionPedidos.service;

import com.springboot.gestionPedidos.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    OrderDTO save(OrderDTO orderDTO);

    OrderDTO update(Long id, OrderDTO orderDTO);

    void deleteById(Long id);
}
