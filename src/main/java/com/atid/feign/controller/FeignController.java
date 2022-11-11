package com.atid.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atid.feign.domain.RestServerCustomer;

@RestController
@RequestMapping("/api")
public class FeignController {

    @Autowired
    private RestServerClient restServerClient;

    @GetMapping("/customers/all")
    public ResponseEntity<List<RestServerCustomer>> getAllCustomers() {
        List<RestServerCustomer> customers = restServerClient.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<RestServerCustomer> getCustomer(@PathVariable("id") Long id) {
        try {
            RestServerCustomer customer = restServerClient.getCustomer(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<RestServerCustomer> addCustomer(@RequestBody RestServerCustomer customer) {
        try {
            RestServerCustomer newCustomer = restServerClient.addCustomer(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        try {
            restServerClient.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<RestServerCustomer> updateCustomer(@PathVariable("id") Long id, @RequestBody RestServerCustomer customer) {
        try {
            RestServerCustomer updatedCustomer = restServerClient.updateCustomer(id, customer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
