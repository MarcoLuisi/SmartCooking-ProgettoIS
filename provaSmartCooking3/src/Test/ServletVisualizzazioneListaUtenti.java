package Test;

import org.junit.Before;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import Control.VisualizzazioneListaUtenti;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import javax.servlet.ServletException;

public class ServletVisualizzazioneListaUtenti {
	  private VisualizzazioneListaUtenti servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  
	  @Before
	  public void setUp() {
	    servlet = new VisualizzazioneListaUtenti();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void ViewListUser() throws ServletException, IOException {
		  servlet.doGet(request, response);
		    assertEquals("application/json", response.getContentType());	  
	  }

}
