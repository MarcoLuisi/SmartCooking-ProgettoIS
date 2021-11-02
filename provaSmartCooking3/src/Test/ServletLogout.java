package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import Control.*;
import Model.*;
import DAO.*;

import java.io.IOException;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;


public class ServletLogout extends Mockito{
	
	  private Logout servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	
	  @Before
	  public void setUp() {
	    servlet = new Logout();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void logOut() throws ServletException, IOException  {
		  servlet.doGet(request, response);
	  } 

}
