package Test;

import org.junit.Before

;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import Control.RemoveVideoAdmin;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import javax.servlet.ServletException;

public class ServletRemoveVideoAdmin extends Mockito{
	
	private RemoveVideoAdmin servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  
	  @Before
	  public void setUp() {
	    servlet = new RemoveVideoAdmin();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void VideoNonPresente() throws ServletException, IOException  {  
		  request.addParameter("titolo","Torta di Alfonso Pepe");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  @Test
	  public void rimuoviVideo() throws ServletException, IOException {
		  request.addParameter("titolo","Panettone di Alfonso Pepe");
		  servlet.doPost(request, response);
	  }

	

}
