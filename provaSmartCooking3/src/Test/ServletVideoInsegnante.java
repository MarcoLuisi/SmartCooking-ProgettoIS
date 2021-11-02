/*
package Test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import Control.VideoInsegnante;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import javax.servlet.ServletException;

public class ServletVideoInsegnante extends Mockito{
	
	  private VideoInsegnante servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  
	  @Before
	  public void setUp() {
	    servlet = new VideoInsegnante();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void InsegnanteNonValido() throws ServletException, IOException {
		  request.addParameter("val", "Michele Rossi");
		  assertThrows(IllegalArgumentException.class, () -> {
		      servlet.doGet(request, response);
		    });	  	  
	  }
	  
	  @Test
	  public void ViewListByInsegnante() throws ServletException, IOException {
		  request.addParameter("val","Alfonso Pepe");
		  servlet.doGet(request, response);
		    assertEquals("application/json", response.getContentType());		  
	  }

}
*/