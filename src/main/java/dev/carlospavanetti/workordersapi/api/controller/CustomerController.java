package dev.carlospavanetti.workordersapi.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carlospavanetti.workordersapi.domain.model.Customer;

@RestController
public class CustomerController {
  @GetMapping("/customers")
  public List<Customer> list() {
    var customer1 = new Customer(1L, "João", "12 9876-1322", "joao@gmail.com");
    var customer2 = new Customer(2L, "Maria", "12 9764-5423", "maria@hotmail.com");
    return Arrays.asList(customer1, customer2);
  }
}
