package com.springboot.gestionPedidos.service.impl;

import com.springboot.gestionPedidos.dto.OrderItemDTO;
import com.springboot.gestionPedidos.entity.OrderItem;
import com.springboot.gestionPedidos.exception.ResponseNotFoundException;
import com.springboot.gestionPedidos.mapper.OrderItemMapper;
import com.springboot.gestionPedidos.repository.OrderItemRepository;
import com.springboot.gestionPedidos.service.OrderItemService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public List<OrderItemDTO> findAll() {
        log.info("Se uestran todos los pedidos con sus clientes");
        return orderItemRepository.findAll()
                .stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO findById(Long id) {
        log.info("Se muestra el pedido con id {}", id);
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha encontrado el pedido con id " + id));
        return orderItemMapper.toDTO(orderItem);
    }

    @Override
    @Transactional
    public OrderItemDTO save(OrderItemDTO orderItemDTO) {
        log.info("Se guarda el pedido {}", orderItemDTO.getOrder());
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDTO(orderItem);
    }

    @Override
    @Transactional
    public OrderItemDTO update(Long id, OrderItemDTO orderItemDTO) {
        log.info("Se actualiza el producto con id {}", id );
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha encontrado pedido con id " +id));
        orderItem.setOder(orderItemDTO.getOrder());
        orderItem.setProduct(orderItemDTO.getProduct());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setUnitPrice(orderItemDTO.getUnitPrice());
        orderItemRepository.save(orderItem);
        return orderItemMapper.toDTO(orderItem);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Se elimina el pedido con id {}", id);
        if (!orderItemRepository.existsById(id)) {
            throw new ResponseNotFoundException("No se ha encontrado el pedido con id " +id);
        }
        orderItemRepository.deleteById(id);
    }

}
