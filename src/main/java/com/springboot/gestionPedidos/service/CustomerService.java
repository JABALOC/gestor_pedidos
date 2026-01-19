package com.springboot.gestionPedidos.service;

import com.springboot.gestionPedidos.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO update(Long id, CustomerDTO customerDTO);

    void deleteById(Long id);

    List<CustomerDTO> findAllActive();

    List<CustomerDTO> findByName(String name);

    CustomerDTO desactive(Long id, Boolean active);
}
