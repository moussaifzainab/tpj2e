package com.employees.webapp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
  private Long id;          // <-- passe en Long
  private String firstName;
  private String lastName;
  private String mail;
  private String password;
}
