// api_sb/src/main/java/com/myHR/api_sb/controller/EmployeeController.java
package com.myHR.api_sb.controller;

import com.myHR.api_sb.model.Employee;
import com.myHR.api_sb.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeRepository repo;

  @GetMapping
  public Iterable<Employee> getAll() { return repo.findAll(); }

  // >>>>>>>>>>>>>>>>>>>>>>> AJOUTE/VERIFIE CET ENDPOINT <<<<<<<<<<<<<<<<<<<<<<
  @GetMapping("/{id}")
  public ResponseEntity<Employee> getById(@PathVariable Long id) {
    return repo.findById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Employee create(@RequestBody Employee e) { return repo.save(e); }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee e) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    e.setId(id);
    return ResponseEntity.ok(repo.save(e));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
