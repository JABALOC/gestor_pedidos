package com.springboot.gestionPedidos.controller;

import com.springboot.gestionPedidos.dto.OrderDTO;
import com.springboot.gestionPedidos.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.save(orderDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.update(id, orderDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
