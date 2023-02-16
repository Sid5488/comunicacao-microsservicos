package br.com.productapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class HealthCheckController {
    @GetMapping("/health-check")
    public ResponseEntity<HashMap<String, Object>> healthCheck() {
        var response = new HashMap<String, Object>();

        response.put("service", "product-api");
        response.put("status", "online");
        response.put("httpStatus", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
}
