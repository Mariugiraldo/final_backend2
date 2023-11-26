package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @PostMapping("/create")
    public ResponseEntity<Bill> save(@RequestBody Bill bill) {
        if (bill == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La factura no puede ser nula");
        }

        if (bill.getCustomerId() == null || bill.getCustomerId().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id del usuario no puede ser nulo/vacio");
        }

        return ResponseEntity.ok(service.saveBill(bill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Bill>> findBillById(@PathVariable String id) {
        List<Bill> bills = service.findBillsByUserId(id);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
}
