package com.rbasystems.poc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbasystems.poc.model.EmployeeEntity;
import com.rbasystems.poc.service.EmployeeService;

/**
 * This is employee rest api to support different operations on {@link EmployeeEntity} resource.
 * 
 * @author Amar Deep Singh
 * @since 1.0.0.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeRestApi {
  @Autowired
  private EmployeeService employeeService;

  /**
   * This endpoint is used to create a new employee in organization and it validates if there is already an existing
   * employee exists with similar details then it throws validation error else it creates a new employee. This end-point
   * expects the minimum required details to be present before creating employee.
   * 
   * @param employeeEntity employee required details.
   * @return returns newly created employee id with 201 {@link HttpStatus} code.
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Long> createEmployee(@RequestBody EmployeeEntity employeeEntity) {
    
    EmployeeEntity updatedEmp = employeeService.saveEmployee(employeeEntity);

    return new ResponseEntity<Long>(updatedEmp.getId(), HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public boolean updateEmployee(@RequestBody EmployeeEntity employee) {

    return employeeService.updateEmployee(employee);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public boolean deleteEmployee(Long employeeId) {
    return employeeService.deleteEmployee(employeeId);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public EmployeeEntity loadEmployee(@PathVariable("id") Long employeeId) {
    return employeeService.loadEmployeeById(employeeId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<EmployeeEntity> loadEmployees() {
    return employeeService.listAllEmployees();
  }
}
