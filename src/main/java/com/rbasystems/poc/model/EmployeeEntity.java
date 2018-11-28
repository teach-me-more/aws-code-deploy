package com.rbasystems.poc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * This class represents an employee within an organization
 * 
 * @author Amar Deep Singh
 *
 */
@Entity
public class EmployeeEntity implements Serializable {
  private static final long serialVersionUID = 6892153655709861134L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  private String emailId;
  private Date dateOfBirth;
  private String phoneNumber;
  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  private List<AddressEntity> addresses;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the emailId
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * @param emailId the emailId to set
   */
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  /**
   * @return the dateOfBirth
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @param dateOfBirth the dateOfBirth to set
   */
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the addresses
   */
  public List<AddressEntity> getAddresses() {
    return addresses;
  }

  /**
   * @param addresses the addresses to set
   */
  public void setAddresses(List<AddressEntity> addresses) {
    this.addresses = addresses;
  }
}
