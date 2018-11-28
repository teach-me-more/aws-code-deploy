package com.rbasystems.poc.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * This class is a sample test class for Hello World Service.
 * 
 * @author Amar Deep Singh
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ApplicationRestServiceTest {

  @InjectMocks
  public ApplicationRestService underTest;

  @Test
  public void testHelloWorld() {
    assertEquals("Hello World !", underTest.sayHello());
  }
}
