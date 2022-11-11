package com.atid.feign.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.atid.feign.domain.RestServerCustomer;

@FeignClient(name = "account-service", url = "http://localhost:8083")
public interface RestServerClient {
    @GetMapping("/api/customers/all")
    public List<RestServerCustomer> getAllCustomers();

    @GetMapping("/api/customers/{id}")
    public RestServerCustomer getCustomer(@PathVariable("id") Long id);

    @PostMapping("/api/customers")
    public RestServerCustomer addCustomer(RestServerCustomer customer);

    @DeleteMapping("/api/customers/delete/{id}")
    public RestServerCustomer deleteCustomer(@PathVariable("id") Long id);

    @PutMapping("/api/customers/update/{id}")
    public RestServerCustomer updateCustomer(@PathVariable("id") Long id, RestServerCustomer customer);


}
