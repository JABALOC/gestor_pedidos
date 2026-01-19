package com.springboot.gestionPedidos.controller;

import com.springboot.gestionPedidos.dto.CustomerDTO;
import com.springboot.gestionPedidos.entity.Customer;
import com.springboot.gestionPedidos.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO created = customerService.save(customerDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.update(id, customerDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public List<CustomerDTO> findAllActive() {
        return customerService.findAllActive();
    }

    @GetMapping("/name/{name}")
    public List<CustomerDTO> findByName(@PathVariable String name) {
        return customerService.findByName(name);
    }

    @PutMapping("/desactive/{id}/{active}")
    public ResponseEntity<CustomerDTO> desactive(@PathVariable Long id, @PathVariable Boolean active) {
        return ResponseEntity.ok(customerService.desactive(id, active));
    }

}
