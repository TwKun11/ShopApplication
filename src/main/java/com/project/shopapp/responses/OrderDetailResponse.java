package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.model.Order;
import com.project.shopapp.model.OrderDetail;
import com.project.shopapp.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResponse {


    @JsonProperty("order_id")
    private long orderId;

    @ManyToOne
    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("number_of_products")
    private int numberOfProducts;

    @JsonProperty("total_money")
    private Float totalMoney;
    @JsonProperty("color")
    private String color;
    public static OrderDetailResponse fromOrder(OrderDetail orderDetail) {
        return OrderDetailResponse.builder()
                .orderId(orderDetail.getOrder().getId())
                .productId(orderDetail.getOrder().getId())
                .price(orderDetail.getPrice())
                .color(orderDetail.getColor())
                .totalMoney(orderDetail.getTotalMoney())
                .numberOfProducts(orderDetail.getNumberOfProducts())
                .build();
    }
}
