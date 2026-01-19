package com.springboot.gestionPedidos.controller;

import com.springboot.gestionPedidos.dto.CustomerDTO;
import com.springboot.gestionPedidos.dto.ProductDTO;
import com.springboot.gestionPedidos.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.save(productDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTo) {
        return ResponseEntity.ok(productService.update(id, productDTo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDTO> findByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

    @PutMapping("/desactive/{id}/{active}")
    public ResponseEntity<ProductDTO> desactive(@PathVariable Long id, @PathVariable Boolean active) {
        return ResponseEntity.ok(productService.desactive(id, active));
    }


}
