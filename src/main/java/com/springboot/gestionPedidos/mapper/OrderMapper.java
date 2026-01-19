package com.springboot.gestionPedidos.mapper;

import com.springboot.gestionPedidos.dto.OrderDTO;
import com.springboot.gestionPedidos.entity.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Orders orders) {
        if (orders == null) {
            return null;
        }
        OrderDTO dto = new OrderDTO();
        dto.setId(orders.getId());
        dto.setOrderDate(orders.getOrderDate());
        dto.setCustomer(orders.getCustomer());

        return dto;
    }

    public Orders toEntity (OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        Orders order = new Orders();
        order.setId(dto.getId());
        order.setOrderDate(dto.getOrderDate());
        order.setCustomer(dto.getCustomer());
        return order;
    }
}
