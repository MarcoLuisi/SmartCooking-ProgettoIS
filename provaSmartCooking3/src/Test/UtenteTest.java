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


public class UtenteTest {
	
	 @Test
	  public void testUtenteCostructorEmpty() {
	    Utente u = new Utente();
	    assertNotNull(u);
	  }
	 
	 @Test
	  public void testGetEmail() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "","","","","","","");
	    assertEquals("paoloRossi80@gmail.com",u.getEmail());
	  }
	 
	 @Test
	  public void testGetPassword() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","","","","","","");
	    assertEquals("12345678", u.getPassword());
	  }
	 
	 @Test
	  public void testGetNome() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","","","","","");
	    assertEquals("Vincenzo", u.getNome());
	  }
	 
	 @Test
	  public void testGetCognome() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","","","","");
	    assertEquals("Neri", u.getCognome());
	  }
	 
	 @Test
	  public void testGetDataNascita() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","","","");
	    assertEquals("1989-10-10", u.getDataNascita());
	  }
	 
	 
	 @Test
	  public void testGetTelefono() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","","");
	    assertEquals("3334445556", u.getTelefono());
	  }
	 
	 @Test
	  public void testGetInizioAbb() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","");
	    assertEquals("2021-10-10", u.getInizioAbbonamento());
	  }
	 
	 
	 @Test
	  public void testGetFineAbb() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    assertEquals("2022-10-10", u.getFineAbbonamento());
	  }
	 
	 
	 @Test
	  public void testSetEmail() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setEmail("Rossi80@gmail.com");
	    assertEquals("Rossi80@gmail.com", u.getEmail());
	  }
	 
	 @Test
	  public void testSetPassword() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setPassword("abcd1111");
	    assertEquals("abcd1111", u.getPassword());
	  }
	 
	 
	 @Test
	  public void testSetNome() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setNome("Giacomo");
	    assertEquals("Giacomo", u.getNome());
	  }
	 
	 @Test
	  public void testSetCognome() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setCognome("Bianchi");
	    assertEquals("Bianchi", u.getCognome());
	  }
	 
	 @Test
	  public void testSetDataNascita() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setDataNascita("1988-11-11");
	    assertEquals("1988-11-11", u.getDataNascita());
	  }
	 
	 @Test
	  public void testSetTelefono() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setTelefono("0001112223");
	    assertEquals("0001112223", u.getTelefono());
	  }
	 
	 @Test
	  public void testSetInizioAbb() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setInizioAbbonamento("2021-12-12");
	    assertEquals("2021-12-12", u.getInizioAbbonamento());
	  }
	 
	 @Test
	  public void testSetFineAbb() {
	    Utente u = new Utente("paoloRossi80@gmail.com", "12345678","Vincenzo","Neri","1989-10-10","3334445556","2021-10-10","2022-10-10");
	    u.setFineAbbonamento("2022-12-12");
	    assertEquals("2022-12-12", u.getFineAbbonamento());
	  }

}
