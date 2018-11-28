## Mocking Guide 
## Author
#### Amar Deep Singh 
## Overview
This document describes that how you can enable mocking in your maven project.This guide uses MockItTo api for java in addition with Power Mock, both API's are really power full in supporting mocking for unit testing. 

## Problem 
 We have an EmployeeRestAPI class which is dependent on EmployeeService. Suppose EmployeeService is not yet ready or we want to test the behavior  of our EmployeeRestAPI in isolation of EmployeeService. EmployeeService can be considered as external service and we need to focus on testing of our class EmployeeRestAPI.  

## Solution 
Here we can consider EmployeeRestService as a class under test and EmployeeService can be considered as dependency which we need to mock or fake the behavior  of EmployeeService. So we need to mock EmployeeService dependency within EmployeeResrService testing
 
Please follow below steps to setup mocking in your project

##### Step 1
Add below dependencies to your project pom
 
 ```
  <dependency>
      <groupId>org.powermock</groupId>
      <artifactId>powermock-module-junit4</artifactId>
      <version>1.7.4</version>
      <scope>test</scope>
 </dependency>
   

 <dependency>
        <groupId>org.powermock</groupId>
        <artifactId>powermock-api-mockito</artifactId>
         <version>1.7.4</version>
         <scope>test</scope>
  </dependency>


   <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
        <version>1.10.19</version>
   </dependency>
   ```
       
##### Step 2 
Create a Test Class named EmployeeRestAPITest

##### Step 3 
Add @RunWith Annotation to EmployeeRestAPITest class

##### Step 4 
Add PowerMockRunner.class to your @RunWith annotation

##### Step 5
Create a private variable of type EmployeeService and annotate this with @Mock annotation

##### Step 6
Create private variable of type EmployeeRestAPI and name it underTest.

##### Step 7 
Add @InjectMocks onEmployeeRestAPI variable you created in step 6.

##### Step 8 
Add a junit method named testCreateEmployeeSuceess

##### Step 9
Add MockItTo.when method when you need to mock something in EmployeeService class. 

		MockItTo.when(employeeService.saveEmployee(any(EmployeeEntity.class))).thenReturn(new EmployeeEntity());

######     Above method will mock the behavior on employeeService's saveEmployee method and whenever you call that method it will intercept and return you a new Employee object.

### Sample Code
```
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@SuppressWarnings("unchecked")
public class EmployeeRestApiTest {
  @Mock
  private EmployeeService employeeService;

  @Mock
  private EmployeeEntity mockedEmployee;


  @InjectMocks
  private EmployeeRestApi undertest;

  @Test
  public void testCreateEmployeeSuceess() throws ServiceException {
    EmployeeEntity employeeEntity = createEmployeeObj(false);
    when(employeeService.saveEmployee(any(EmployeeEntity.class))).thenReturn(mockedEmployee);

    ResponseEntity<Long> response = undertest.createEmployee(employeeEntity);

    assertNotNull(response);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertTrue(response.hasBody());
    assertEquals(ID, response.getBody());
  }
}
```

### Mocking Static method
Below example shows how you can mock a static method example -LocaleContextHolder.getLocaleContext() 
#### Step 1. 
Add PowerMockRunner.class to your @RunWith annotation
#### Step 2 
Add annotation @PrepareForTest to your class and add the class name which you want to call static method on. example 
@PrepareForTest(LocaleContextHolder.class)

#### Step 3
In Your test method call PowerMockito.mockStatic() method on static class.
#### Step 4
Call the static method with help of MockItTo.when() and return expected result.

### Sample Code
```

@RunWith(PowerMockRunner.class)
@PrepareForTest(LocaleContextHolder.class)
public class SpringApplicationContextTest {
  @Mock
  private LocaleContext localeContext;

  @Mock
  private Environment environment;

  @Mock
  private ApplicationContext applicationContext;

  @InjectMocks
  private SpringApplicationContext underTest;


  @Test
  public void testGetMessageWithNotNullAppContext() {
    when(applicationContext.getMessage(anyString(), anyObject(), anyObject())).thenReturn(VALUE);
    underTest.setApplicationContext(applicationContext);
        when(localeContext.getLocale()).thenReturn(Locale.US);
    when(applicationContext.getEnvironment()).thenReturn(environment);
    PowerMockito.mockStatic(LocaleContextHolder.class);
    when(LocaleContextHolder.getLocaleContext()).thenReturn(localeContext);
    assertEquals(VALUE, SpringApplicationContext.getMessage(KEY, null));
  }

}

 ```
 
 ### Mocking Final class method
Below example shows how you can mock a final class method example -AWSKMSClientBuilder's build() 
 // Mocking a final class
    AWSKMSClientBuilder kmsClientBuilder = PowerMockito.mock(AWSKMSClientBuilder.class);
        when(kmsClientBuilder.build()).thenReturn(kms);

#### Step 1. 
Add PowerMockRunner.class to your @RunWith annotation
#### Step 2 
Add annotation @PrepareForTest to your class and add the final class name from which you want to call method for mocking. example 
@PrepareForTest(AWSKMSClientBuilder.class)

#### Step 3
In Your test method call PowerMockito.mock() on final class to create a mock object.

AWSKMSClientBuilder kmsClientBuilder = PowerMockito.mock(AWSKMSClientBuilder.class);
 .
#### Step 4
Mock the call using MockItTo.when()  method with help of MockItTo.when() and return expected result.
### Sample Code

```

@RunWith(PowerMockRunner.class)
@PrepareForTest(AWSKMSClientBuilder.class)
public class FinalClassTest {
  @Mock
  private AWSKMS kms;
  
  @InjectMocks
  private FinalClass underTest;

  @Test
  public void testGetMessageWithNotNullAppContext() {
   when(kmsClientBuilder.withCredentials(anyObject())).thenReturn(kmsClientBuilder);
   when(kmsClientBuilder.build()).thenReturn(kms);
    underTest.callSomeMethod();
  }
}

 ```
 
### Mocking Void method
Below example shows how you can mock a void method example -AWSKMSClientBuilder's setRegion() method

#### Step 1. 
Add PowerMockRunner.class to your @RunWith annotation
#### Step 2 
Add annotation @PrepareForTest to your class and add the class name from which you want to mock the void method. 
Example :
@PrepareForTest(AWSKMSClientBuilder.class)

#### Step 3
In Your test method call Mockito.doNothing() method on mocked object of the class.

doNothing().when(kmsClientBuilder).setRegion(anyString()); .

### Sample Code

```

@RunWith(PowerMockRunner.class)
@PrepareForTest(AWSKMSClientBuilder.class)
public class FinalClassTest {
  @Mock
  private AWSKMS kms;
  
  @InjectMocks
  private FinalClass underTest;

  @Test
  public void testGetMessageWithNotNullAppContext() {
  //final class example 
   AWSKMSClientBuilder kmsClientBuilder = PowerMockito.mock(AWSKMSClientBuilder.class);
   when(kmsClientBuilder.withCredentials(anyObject())).thenReturn(kmsClientBuilder);
   when(kmsClientBuilder.build()).thenReturn(kms);
   
   //Void method example
   doNothing().when(kmsClientBuilder).setRegion(anyString()); .
    underTest.callSomeMethod();
  }
}

 ```
 
