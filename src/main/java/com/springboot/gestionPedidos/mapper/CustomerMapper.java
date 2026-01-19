package com.springboot.gestionPedidos.mapper;

import com.springboot.gestionPedidos.dto.CustomerDTO;
import com.springboot.gestionPedidos.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setActive(customer.getActive());
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setActive(dto.getActive());
        return customer;
    }
}
