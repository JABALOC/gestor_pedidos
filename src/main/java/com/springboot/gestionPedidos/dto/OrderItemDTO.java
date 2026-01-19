package com.springboot.gestionPedidos.dto;

public class OrderItemDTO {

    private Long id;
    private String order;
    private String productName;
    private Integer quantity;
    private Double unitPrice;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long id, String order, String productName, Integer quantity, Double unitPrice) {
        this.id = id;
        this.order = order;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getProduct() {
        return productName;
    }

    public void setProduct(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
