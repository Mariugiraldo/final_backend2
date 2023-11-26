package com.example.msusers.controller.response;

import com.example.msusers.domain.User;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserBillsResponse {
    @JsonUnwrapped
    private User user;
    private List<BillDTO> bills;
}