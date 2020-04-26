package dev.carlospavanetti.workordersapi.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.carlospavanetti.workordersapi.domain.model.Customer;

@RestController
public class CustomerController {
  @PersistenceContext
  private EntityManager manager;

  @GetMapping("/customers")
  public List<Customer> list() {
    return manager.createQuery("from Customers", Customer.class).getResultList();
  }
}
