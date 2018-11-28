package com.rbasystems.poc.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rbasystems.poc.model.EmployeeEntity;


/**
 * This repository allow to perform CRUD operations on {@link EmployeeEntity}
 * 
 * @author Amar Deep Singh
 * @since 1.0.0.0
 */
public interface EmployeeRepositoryDao extends CrudRepository<EmployeeEntity, Long> {
  @Override
  List<EmployeeEntity> findAll();

  List<EmployeeEntity> findByFirstName(@Param("firstName") String firstName);

  List<EmployeeEntity> findByFirstNameAndLastName(@Param("firstName") String firstName,
      @Param("lastName") String lastName);

}
