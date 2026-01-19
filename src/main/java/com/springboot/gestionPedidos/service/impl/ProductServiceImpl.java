package com.springboot.gestionPedidos.service.impl;

import com.springboot.gestionPedidos.dto.ProductDTO;
import com.springboot.gestionPedidos.entity.Product;
import com.springboot.gestionPedidos.exception.ResponseNotFoundException;
import com.springboot.gestionPedidos.mapper.ProductMapper;
import com.springboot.gestionPedidos.repository.ProductRepository;
import com.springboot.gestionPedidos.service.ProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        log.info("Se muestran todos los productos");
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        log.info("Este es el producto con id {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha podido encontrar el id " + id));
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        log.info("Se va a guardar el producto con nombre: {}", productDTO.getName());
        Product product = productMapper.toEntity(productDTO);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        log.info("Se actualiza el producto con id {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha podido encontrar el producto con id " + id));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setActive(productDTO.getActive());
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Se va a eliminar el producto con id {}", id);
        if (!productRepository.existsById(id)) {
            throw new ResponseNotFoundException("No existe el producto con id " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO findByName(String name) {
        log.info("Buscar producto por el nombre: '{}'", name);
        Product product = productRepository.findByName(name);
        return productMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO desactive(Long id, Boolean active) {
        log.info("Activar/Desactivar producto con id {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseNotFoundException("No se ha encontrado producto con id " + id));
        product.setActive(active);
        return productMapper.toDTO(product);

    }


}
