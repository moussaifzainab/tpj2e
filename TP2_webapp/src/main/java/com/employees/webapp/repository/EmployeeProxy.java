package com.employees.webapp.repository;

import com.employees.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {

  @Autowired
  private CustomProperties props;

  /** GET /employees */
  public Iterable<Employee> getEmployees() {
    String baseApiUrl = props.getApiUrl();
    String getEmployeesUrl = baseApiUrl + "/employees";
    System.out.println("EmployeeProxy *** getEmployees() getEmployeesUrl  " + getEmployeesUrl);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
        getEmployeesUrl,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Iterable<Employee>>() {}
    );

    System.out.println("EmployeeProxy *** getEmployees() response.getBody()  " + response.getBody());
    log.debug("Get Employees call {}", response.getStatusCode());
    return response.getBody();
  }

  /** GET /employees/{id} */
  public Employee getEmployee(long id) {
    String url = props.getApiUrl() + "/employees/" + id;
    return new RestTemplate().getForObject(url, Employee.class);
  }

  /** POST /employees */
  public Employee createEmployee(Employee e) {
    String url = props.getApiUrl() + "/employees";
    return new RestTemplate().postForObject(url, e, Employee.class);
  }

  /** PUT /employees/{id} */
  public Employee updateEmployee(Employee e) {
    String url = props.getApiUrl() + "/employees/" + e.getId();
    new RestTemplate().put(url, e);
    return e;
  }

  /** DELETE /employees/{id} */
  public void deleteEmployee(long id) {
    String url = props.getApiUrl() + "/employees/" + id;
    new RestTemplate().delete(url);
  }
}
