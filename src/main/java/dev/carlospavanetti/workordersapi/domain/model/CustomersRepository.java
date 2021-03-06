package dev.carlospavanetti.workordersapi.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
  Customer findByEmail(String email);
}
