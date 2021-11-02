package Test;



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

public class VideoTest {
	
	 @Test
	  public void testVideoCostructorEmpty() {
	    Video v = new Video();
	    assertNotNull(v);
	  }
	 
	 @Test
	  public void testGetIdVideo() {
	    Video v = new Video(1,"","",false);
	    assertEquals(1,v.getIdVideo());
	  }
	 
	 @Test
	  public void testGetTitolo() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","",false);
	    assertEquals("Spaghetti di Mario Rossi",v.getTitolo());
	  }
	 
	 @Test
	  public void testGetCategoria() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","Primi",false);
	    assertEquals("Primi",v.getCategoria());
	  }
	 
	 @Test
	  public void testIsGratuito() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","Primi",false);
	    assertEquals(false,v.isGratuito());
	  }
	 
	 
	 @Test
	  public void testSetIdVideo() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","Primi",false);
	    v.setIdVideo(2);
	    assertEquals(2, v.getIdVideo());
	  }
	 
	 @Test
	  public void testSetTitolo() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","Primi",false);
	    v.setTitolo("Riso di Mario Rossi");
	    assertEquals("Riso di Mario Rossi", v.getTitolo());
	  }
	 
	 @Test
	  public void testSetCategoria() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","Contorni",false);
	    v.setCategoria("Contorni");
	    assertEquals("Contorni", v.getCategoria());
	  }
	 
	 
	 
	 @Test
	  public void testSetGratuito() {
	    Video v = new Video(1,"Spaghetti di Mario Rossi","Contorni",false);
	    v.setGratuito(true);
	    assertEquals(true, v.isGratuito());
	  }
	 
	 
	 

}
