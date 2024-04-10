package com.security.jwt.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @GetMapping
    public Map<String, String> accounts() {
        //... business logic
        return Collections.singletonMap("msj", "accounts");
    }
}
