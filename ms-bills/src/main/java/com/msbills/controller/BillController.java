package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String>createBills(@RequestBody Bill bills){
        return new ResponseEntity<>("Factura creada exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<String>findById(@PathVariable String userId){
        return new ResponseEntity<>("Facturas encontradas para el usuario: " + userId, HttpStatus.OK);
    }
}
