package dev.carlospavanetti.workordersapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.carlospavanetti.workordersapi.domain.model.Customer;
import dev.carlospavanetti.workordersapi.domain.model.CustomersRepository;
import dev.carlospavanetti.workordersapi.exception.BusinessException;

@Service
public class CustomerRegisteringService {
  @Autowired
  private CustomersRepository repository;

  public Customer save(Customer customer) {
    Customer withEmail = repository.findByEmail(customer.getEmail());
    if (withEmail != null && !withEmail.equals(customer)) {
      throw new BusinessException("There is already a customer with this email");
    }
    return repository.save(customer);
  }

  public void destroy(Long id) {
    repository.deleteById(id);
  }
}
