package com.rbasystems.poc.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * This Entity represents the address of an {@link Employee}
 * 
 * @author Amar Deep Singh
 * @since 1.0.0.0
 */
@Entity
public class AddressEntity implements Serializable {
  private static final long serialVersionUID = 6160604683003521621L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long addressId;
  @ManyToOne
  private EmployeeEntity employee;
  private String addressLineOne;
  private String addressLineTwo;
  private String cityName;
  private String state;
  private String zipCode;

  /**
   * @return the addressId
   */
  public Long getAddressId() {
    return addressId;
  }

  /**
   * @param addressId the addressId to set
   */
  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  /**
   * @return the employee
   */
  public EmployeeEntity getEmployee() {
    return employee;
  }

  /**
   * @param employee the employee to set
   */
  public void setEmployee(EmployeeEntity employee) {
    this.employee = employee;
  }

  /**
   * @return the addressLineOne
   */
  public String getAddressLineOne() {
    return addressLineOne;
  }

  /**
   * @param addressLineOne the addressLineOne to set
   */
  public void setAddressLineOne(String addressLineOne) {
    this.addressLineOne = addressLineOne;
  }

  /**
   * @return the addressLineTwo
   */
  public String getAddressLineTwo() {
    return addressLineTwo;
  }

  /**
   * @param addressLineTwo the addressLineTwo to set
   */
  public void setAddressLineTwo(String addressLineTwo) {
    this.addressLineTwo = addressLineTwo;
  }

  /**
   * @return the cityName
   */
  public String getCityName() {
    return cityName;
  }

  /**
   * @param cityName the cityName to set
   */
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @return the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * @param zipCode the zipCode to set
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
}
