package com.springboot.gestionPedidos.service.impl;

import com.springboot.gestionPedidos.dto.OrderDTO;
import com.springboot.gestionPedidos.entity.Orders;
import com.springboot.gestionPedidos.exception.ResponseNotFoundException;
import com.springboot.gestionPedidos.mapper.OrderMapper;
import com.springboot.gestionPedidos.repository.OrderRepository;
import com.springboot.gestionPedidos.service.OrderService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> findAll() {
        log.info("Listado de todas las ordenes");
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        log.info("Esta es la orden con número de id {}", id);
        Orders orders = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha podido encontrar el pedido con id " + id));
        return orderMapper.toDTO(orders);
    }

    @Override
    @Transactional
    public OrderDTO save(OrderDTO orderDTO) {
        log.info("Se guarda pedido para el cliente '{}' con fecha {}", orderDTO.getCustomer(), orderDTO.getOrderDate());
        Orders guarder = orderMapper.toEntity(orderDTO);
        orderRepository.save(guarder);
        return orderMapper.toDTO(guarder);
    }

    @Override
    @Transactional
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        log.info("Se ha actualixado el pedido con id {}", id);
        Orders order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha encontrado pedido con el id " + id));

        order.setCustomer(orderDTO.getCustomer());
        order.setOrderDate(orderDTO.getOrderDate());
        return orderMapper.toDTO(order);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Se va a eliminar el pedido con id {}", id);
        orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha encontrado el pedido con id " + id));
        orderRepository.deleteById(id);
    }



}
