package com.rbasystems.poc.service;

import java.util.List;

import com.rbasystems.poc.model.EmployeeEntity;

/**
 * This interface allow to manage Employees within an organization.
 * 
 * @author Amar Deep Sing
 * @since 1.0.0.0
 *
 */
public interface EmployeeService {

  public EmployeeEntity saveEmployee(EmployeeEntity employee);

  public boolean updateEmployee(EmployeeEntity employee);

  public EmployeeEntity loadEmployeeById(Long id);

  public boolean deleteEmployee(Long id);

  public List<EmployeeEntity> listAllEmployees();
}
