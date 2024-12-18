package com.project.shopapp.repository;

import com.project.shopapp.model.Category;
import com.project.shopapp.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
List<OrderDetail> findByOrderId(long orderId);
}
