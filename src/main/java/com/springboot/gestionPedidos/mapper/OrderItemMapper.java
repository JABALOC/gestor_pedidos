package com.springboot.gestionPedidos.mapper;

import com.springboot.gestionPedidos.dto.OrderItemDTO;
import com.springboot.gestionPedidos.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemDTO toDTO(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(orderItem.getId());
        dto.setOrder(orderItem.getOder());
        dto.setProduct(orderItem.getProduct());
        dto.setQuantity(orderItem.getQuantity());
        dto.setUnitPrice(orderItem.getUnitPrice());
        return dto;
    }

    public OrderItem toEntity(OrderItemDTO dto) {
        if (dto == null) {
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setId(dto.getId());
        orderItem.setOder(dto.getOrder());
        orderItem.setProduct(dto.getProduct());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setUnitPrice(dto.getUnitPrice());
        return orderItem;
    }
}
