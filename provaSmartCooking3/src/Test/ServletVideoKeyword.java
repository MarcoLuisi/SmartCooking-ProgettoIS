package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import Control.VideoCategoria;
import Control.VideoKeyword;

public class ServletVideoKeyword {
	
	 private VideoKeyword servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  
	  @Before
	  public void setUp() {
	    servlet = new VideoKeyword();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void KeyWordVuota() throws ServletException, IOException {
		  request.addParameter("val","");
		   assertThrows(IllegalArgumentException.class, () -> {
			      servlet.doGet(request, response);
			    });	  
	  }
	  
	  @Test
	  public void ViewListByKeyword() throws ServletException, IOException {
		  request.addParameter("val","Pollo");
		  servlet.doGet(request, response);
		    assertEquals("application/json", response.getContentType());		  
	  }

}
