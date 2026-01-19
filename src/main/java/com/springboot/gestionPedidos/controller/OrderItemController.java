package com.springboot.gestionPedidos.controller;

import com.springboot.gestionPedidos.dto.OrderItemDTO;
import com.springboot.gestionPedidos.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/all")
    public List<OrderItemDTO> findAll() {
        return orderItemService.findAll();
    }

    @GetMapping("/orderItem/{id}")
    public ResponseEntity<OrderItemDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderItemService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItemDTO> save(@RequestBody OrderItemDTO orderItemDTO) {
        return ResponseEntity.ok(orderItemService.save(orderItemDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderItemDTO> update(@PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        return ResponseEntity.ok(orderItemService.update(id, orderItemDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        orderItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
