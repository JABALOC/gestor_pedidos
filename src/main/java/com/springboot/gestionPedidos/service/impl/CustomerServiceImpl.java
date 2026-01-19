package com.springboot.gestionPedidos.service.impl;

import com.springboot.gestionPedidos.dto.CustomerDTO;
import com.springboot.gestionPedidos.entity.Customer;
import com.springboot.gestionPedidos.exception.ResponseNotFoundException;
import com.springboot.gestionPedidos.mapper.CustomerMapper;
import com.springboot.gestionPedidos.repository.CustomerRepository;
import com.springboot.gestionPedidos.service.CustomerService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;


    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> findAll() {
        log.info("Listado con todos los Clientes");
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        log.info("Se muestra el cliente con id {}", id);
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha encontrado el id: " + id));
        return customerMapper.toDTO(customer);
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        log.info("Se ha creado el siguiente cliente: '{} {}'", customerDTO.getName(), customerDTO.getLastName());
        Customer customer = customerMapper.toEntity(customerDTO);
        Customer guardar = customerRepository.save(customer);
        return customerMapper.toDTO(guardar);
    }

    @Override
    @Transactional
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        log.info("Se actualiza el cliente con id {}", id);
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("Cliente no encontrado con id " + id));
        customer.setName(customerDTO.getName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setActive(customerDTO.getActive());
        return customerMapper.toDTO(customer);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Se elimina el cliente con id {}", id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO> findAllActive() {
        log.info("Mostrar solo clientes activos");
        return customerRepository.findAll()
                .stream()
                .filter(Customer::getActive)
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findByName(String name) {
        log.info("Se muestran clientes con nombre '{}'", name);
        return customerRepository.findByName(name)
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerDTO desactive(Long id, Boolean active) {
        log.info("Desactivar clientes");
        Customer customer = customerRepository.findById(id)
                        .orElseThrow(() ->
                                new ResponseNotFoundException("No se ha encontrado el cliente con id " + id));
        customer.setActive(active);
        return customerMapper.toDTO(customer);
    }


}
