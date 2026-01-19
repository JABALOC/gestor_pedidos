package com.springboot.gestionPedidos.dto;

import com.springboot.gestionPedidos.entity.Customer;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long id;
    private String orderDate;
    private String customer;

    private Long CustomerId;
    private String status;


    public OrderDTO() {

    }

    public OrderDTO(Long id, String orderDate, String customer, Long customerId, String status) {
        this.id = id;
        this.orderDate = orderDate;
        this.customer = customer;
        this.CustomerId = customerId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
