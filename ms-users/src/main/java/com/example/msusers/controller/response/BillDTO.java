package com.example.msusers.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BillDTO {
    private String idBill;
    private String customerId;
    private String productId;
    private Double totalPrice;
}
