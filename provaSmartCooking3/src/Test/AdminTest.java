package Test;

import org.junit.Before;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import Control.*;
import Model.*;


import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;


public class AdminTest {
	
	 @Test
	  public void testAdminCostructorEmpty() {
	    Admin ad = new Admin();
	    assertNotNull(ad);
	  }
	 
	 @Test
	  public void testGetEmail() {
	    Admin ad = new Admin("paoloRossi80@gmail.com", "");
	    assertEquals("paoloRossi80@gmail.com", ad.getEmail());
	  }
	 
	 @Test
	  public void testGetPassword() {
	    Admin ad = new Admin("paoloRossi80@gmail.com", "12345678");
	    assertEquals("12345678", ad.getPassword());
	  }
	 
	 
	 
	 @Test
	  public void testSetEmail() {
	    Admin ad = new Admin("paoloRossi80@gmail.com", "12345678");
	    ad.setEmail("robertoRossi60@gmail.com");
	    assertEquals("robertoRossi60@gmail.com", ad.getEmail());
	  }
	 
	 @Test
	  public void testSetPassword() {
	    Admin ad = new Admin("paoloRossi80@gmail.com", "12345678");
	    ad.setPassword("87654321");
	    assertEquals("87654321", ad.getPassword());
	  }

}
