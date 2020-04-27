package dev.carlospavanetti.workordersapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.carlospavanetti.workordersapi.domain.model.Customer;
import dev.carlospavanetti.workordersapi.domain.model.CustomersRepository;
import dev.carlospavanetti.workordersapi.service.CustomerRegisteringService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  @Autowired
  private CustomersRepository repository;

  @Autowired
  private CustomerRegisteringService customerRegistering;

  @GetMapping
  public List<Customer> list() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> show(@PathVariable Long id) {
    Optional<Customer> customer = repository.findById(id);

    return customer.isPresent() ? ResponseEntity.ok(customer.get()) : ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Customer create(@Valid @RequestBody Customer customer) {
    return customerRegistering.save(customer);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    customer.setId(id);
    repository.save(customer);
    return ResponseEntity.ok(customer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }

    customerRegistering.destroy(id);
    return ResponseEntity.noContent().build();
  }
}
