package com.employees.webapp.service;

import com.employees.webapp.model.Employee;
import com.employees.webapp.repository.EmployeeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeProxy proxy;

  public Employee getEmployee(final Long id) { return proxy.getEmployee(id); }
  public Iterable<Employee> getEmployees() { return proxy.getEmployees(); }
  public void deleteEmployee(final Long id) { proxy.deleteEmployee(id); }

  public Employee saveEmployee(Employee e) {
    if (e.getLastName() != null) e.setLastName(e.getLastName().toUpperCase());
    return (e.getId() == null) ? proxy.createEmployee(e) : proxy.updateEmployee(e);
  }
}
