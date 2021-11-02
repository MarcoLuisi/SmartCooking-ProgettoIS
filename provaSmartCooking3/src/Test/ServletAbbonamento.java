package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertThrows;

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

public class ServletAbbonamento extends Mockito {
	
	  private Abbonamento servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
	    servlet = new Abbonamento();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void UtenteNonPresente() throws ServletException, IOException  {  
		  request.addParameter("email","francescoRossi60@gmail.com");
		  request.addParameter("durata", "annuale");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	
	  
	  @Test
	  public void DurataSbagliata() throws ServletException, IOException  {  
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("durata", "2 mesi");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  }
	  
	  @Test
	  public void addAbbonamento() throws ServletException, IOException  {  
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("durata", "annuale");
	      servlet.doPost(request, response);
	  } 
	
	

}
