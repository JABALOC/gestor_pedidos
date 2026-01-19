package com.springboot.gestionPedidos.service;

import com.springboot.gestionPedidos.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {

    List<OrderItemDTO> findAll();

    OrderItemDTO findById(Long id);

    OrderItemDTO save(OrderItemDTO orderItemDTO);

    OrderItemDTO update(Long id, OrderItemDTO orderItemDTO);

    void deleteById(Long id);
}
