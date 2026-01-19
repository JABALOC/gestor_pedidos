package com.springboot.gestionPedidos.repository;

import com.springboot.gestionPedidos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
