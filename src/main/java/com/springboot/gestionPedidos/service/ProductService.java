package com.springboot.gestionPedidos.service;

import com.springboot.gestionPedidos.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO productDTO);

    void deleteById(Long id);

    ProductDTO findByName(String name);

    ProductDTO desactive(Long id, Boolean active);
}
