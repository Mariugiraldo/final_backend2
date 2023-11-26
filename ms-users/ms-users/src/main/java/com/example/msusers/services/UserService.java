package com.example.msusers.services;

import com.example.msusers.controller.response.BillDTO;
import com.example.msusers.controller.response.UserBillsResponse;
import com.example.msusers.domain.User;
import com.example.msusers.feign.BillClient;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private BillClient billClient;

    @Autowired
    private Keycloak keycloak;

    @Value("${spring.security.oauth2.client.registration.keycloak.realm}")
    private String realm;

    public UserBillsResponse findUserWithBills(String userId) throws Exception {
        User user = this.findUsersById(userId).orElseThrow(() -> new Exception("No existe el usuario con id: " + userId));
        List<BillDTO> bills = billClient.findByUserId(userId);
        return new UserBillsResponse(user, bills);
    }

    private Optional<User> findUsersById(String id) {
        return keycloak.realm(realm)
                .users()
                .list()
                .stream()
                .map(user -> new User(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName()))
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
