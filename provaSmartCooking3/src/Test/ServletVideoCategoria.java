package Test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import Control.VideoCategoria;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import javax.servlet.ServletException;

public class ServletVideoCategoria extends Mockito {
	
	  private VideoCategoria servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  
	  @Before
	  public void setUp() {
	    servlet = new VideoCategoria();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void CategoriaErrata() throws ServletException, IOException {
		  request.addParameter("val","Pizze");
		   assertThrows(IllegalArgumentException.class, () -> {
			      servlet.doGet(request, response);
			    });	  
	  }
	  
	  @Test
	  public void ViewListByCategoria() throws ServletException, IOException {
		  request.addParameter("val","Primi");
		  servlet.doGet(request, response);
		    assertEquals("application/json", response.getContentType());		  
	  }
	
}
