package com.atid.feign.domain;

import lombok.Data;

@Data
public class RestServerCustomer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double fee;
    private double tax;
    private double total;
}
