package com.example.msusers.domain;

import lombok.*;

@AllArgsConstructor
@Data
public class BillsDTO {
    private String idBill;
    private String customerBill;
    private String productBill;
    private Double totalPrice;
}
