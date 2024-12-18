package com.project.shopapp.responses;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductListResponse {
    List<ProductResponse> product;
    int totalPage;
}
