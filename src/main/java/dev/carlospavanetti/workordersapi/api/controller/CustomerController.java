package dev.carlospavanetti.workordersapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carlospavanetti.workordersapi.domain.model.Customer;
import dev.carlospavanetti.workordersapi.domain.model.CustomersRepository;

@RestController
public class CustomerController {
  @Autowired
  private CustomersRepository repository;

  @GetMapping("/customers")
  public List<Customer> list() {
    return repository.findAll();
  }
}
