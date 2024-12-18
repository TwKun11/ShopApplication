

package com.project.shopapp.controller;


import com.project.shopapp.dtos.OrderDetailDTO;
import com.project.shopapp.exception.DataNotFoundException;
import com.project.shopapp.model.Order;
import com.project.shopapp.model.OrderDetail;
import com.project.shopapp.responses.OrderDetailResponse;
import com.project.shopapp.services.OrderDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping
    private ResponseEntity<?> createOrderDetails(@RequestBody @Valid OrderDetailDTO orderDetailDTO) {

        try {
           OrderDetail orderDetail =  orderDetailService.createOrderDetail(orderDetailDTO);
            return ResponseEntity.ok(OrderDetailResponse.fromOrder(orderDetail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getOrderDetail(@Valid @PathVariable("id") long id) {
        try {
        OrderDetail orderDetail = orderDetailService.getOrderDetail(id);
            return ResponseEntity.ok(orderDetail);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // get all order details of order details
    @GetMapping("/order/{orderId}")
    private ResponseEntity<?> getOrderDetails(@Valid @PathVariable("orderId") long orderId) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
        List<OrderDetailResponse> orderDetailResponses = orderDetails.stream()
                .map(OrderDetailResponse::fromOrder).toList();
            return ResponseEntity.ok(orderDetailResponses);

    }

    @PutMapping("/{id}")
    private ResponseEntity<?>  updateOrderDetail(@Valid @PathVariable("id") long id, @RequestBody OrderDetailDTO
            orderDetailDTO) {

        try {
            OrderDetail  orderDetail = orderDetailService.updateOrderDetail(id, orderDetailDTO);
            return ResponseEntity.ok(orderDetail);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteOrderDetail(@Valid @PathVariable("id") long id) {
        try {
            orderDetailService.deleteById(id);
            return ResponseEntity.ok("delete successfully");
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
