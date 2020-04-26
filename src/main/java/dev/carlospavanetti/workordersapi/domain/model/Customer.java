package dev.carlospavanetti.workordersapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Customer {
  private final @Getter Long id;
  private @Getter @Setter String name;
  private @Getter @Setter String email;
  private @Getter @Setter String phone;
}
