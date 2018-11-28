package com.rbasystems.poc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbasystems.poc.dao.EmployeeRepositoryDao;
import com.rbasystems.poc.model.EmployeeEntity;
import com.rbasystems.poc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private EmployeeRepositoryDao employeeDao;


  @Override
  public EmployeeEntity saveEmployee(EmployeeEntity employee) {
    return employeeDao.save(employee);
  }

 
  @Override
  public boolean updateEmployee(EmployeeEntity employee) {
    employeeDao.save(employee);
    return true;
  }


  @Override
  public EmployeeEntity loadEmployeeById(Long id) {
    return employeeDao.findById(id).get();
  }

  
  @Override
  public boolean deleteEmployee(Long id) {
    employeeDao.deleteById(id);
    return true;
  }


  @Override
  public List<EmployeeEntity> listAllEmployees() {
    return employeeDao.findAll();
  }
}
