package dev.carlospavanetti.workordersapi.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity(name = "Customers")
@Table(name = "Customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 255)
  private String name;

  @NotBlank
  @Email
  @Size(max = 255)
  private String email;

  @NotBlank
  @Size(max = 20)
  private String phone;
}
