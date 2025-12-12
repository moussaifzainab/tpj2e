package com.employees.webapp.controller;

import com.employees.webapp.model.Employee;
import com.employees.webapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller        
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService service;

  // Page d'accueil - Liste des employés (+ message flash optionnel)
  @GetMapping("/")
  public String home(Model model, @RequestParam(value = "msg", required = false) String msg) {
    model.addAttribute("employees", service.getEmployees());
    if (msg != null) model.addAttribute("msg", msg);
    return "home";
  }

  @GetMapping("/createEmployee")
  public String createEmployeeForm(Model model) {
    model.addAttribute("employee", new Employee());
    return "formUpdateEmployee";
  }

  @GetMapping("/updateEmployee/{id}")
  public String updateEmployeeForm(@PathVariable("id") Long id, Model model) {
    model.addAttribute("employee", service.getEmployee(id));
    return "formUpdateEmployee";
  }


  // Sauvegarde (création ou modification)
  @PostMapping("/saveEmployee")
  public ModelAndView saveEmployee(@ModelAttribute Employee employee, RedirectAttributes ra) {
    service.saveEmployee(employee);
    ra.addAttribute("msg", (employee.getId() == null) ? "Employé créé" : "Employé mis à jour");
    return new ModelAndView("redirect:/");
  }

  // Suppression (POST, pas GET)
  @PostMapping("/deleteEmployee/{id}")
  public ModelAndView deleteEmployee(@PathVariable("id") Long id, RedirectAttributes ra) {
    service.deleteEmployee(id);
    ra.addAttribute("msg", "Employé supprimé");
    return new ModelAndView("redirect:/");
  }
}
