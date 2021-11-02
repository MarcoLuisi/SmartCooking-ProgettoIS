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

public class ServletLogin extends Mockito {
	
	  private Login servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	
	  @Before
	  public void setUp() {
	    servlet = new Login();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void EmailInesistente() throws ServletException, IOException  {
		  request.addParameter("password","12345678");
		  request.addParameter("email","DavideBianchi@gmail.com");
		  servlet.doPost(request, response);
		  assertNull(request.getSession().getAttribute("user"));
	  } 
	  
	  @Test
	  public void LoginUtenteErrato() throws ServletException, IOException  {
		  request.addParameter("password","82345671");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  servlet.doPost(request, response);
		  assertNull(request.getSession().getAttribute("user"));
	  } 
	  
	  @Test
	  public void LoginAdminErrato() throws ServletException, IOException  {
		  request.addParameter("password","12345679");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  servlet.doPost(request, response);
		  assertNull(request.getSession().getAttribute("admin"));
	  } 
	  
	  @Test
	  public void LoginUtente() throws ServletException, IOException  {
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  servlet.doPost(request, response);
		  assertNotNull(request.getSession().getAttribute("user"));
	  } 
	  
	  @Test
	  public void LoginAdmin() throws ServletException, IOException  {
		  request.addParameter("password","12345678");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  servlet.doPost(request, response);
		  assertNotNull(request.getSession().getAttribute("admin"));
	  } 
	  
	
	
}
