package com.example.msusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String id;
    private String name;
    private String factura;
    private BillsDTO billsDTO;



}
