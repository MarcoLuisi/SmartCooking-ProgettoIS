package DAO;

import Model.Utente;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class MySQLUtenteDAO implements UtenteDAO {

    /** La query per l'inserimento di un nuovo utente */
    private static final String CREATE_QUERY = "INSERT INTO utente (email, passwordUtente, nome, cognome," +
            "dataNascita, telefono, inizioAbbonamento, fineAbbonamento) VALUES (?,?,?,?,?,?,?,?)";

    /** La query per la lettura di un singolo utente. */
    private static final String READ_QUERY = "SELECT * FROM utente WHERE email = ?";

    /** La query per la lettura di tutti gli utenti. */
    private static final String READ_ALL_QUERY = "SELECT * FROM utente";

    /** La query per l'aggiornamento di un singolo utente. */
    private static final String UPDATE_QUERY = "UPDATE utente SET passwordUtente=?, nome=?, cognome=?, " +
            "dataNascita=?, telefono=? WHERE email = ?";

    /** La query per la cancellazione di un singolo utente. */
    private static final String DELETE_QUERY = "DELETE FROM utente WHERE email = ?";

    /**La query per la sottoscrizione dell'abbonamento*/
    private static final String SUBSCRIBE_QUERY = "UPDATE utente set inizioAbbonamento=?, fineAbbonamento=?" +
            "WHERE email=?";

    private static final String GET_EMAILS = "Select email FROM utente";



    @Override
    public List<Utente> getAllUtenti() {
        List<Utente> utenti = new ArrayList<Utente>();
        Utente utente = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_ALL_QUERY);
            statement.execute();
            result = statement.getResultSet();

            while(result.next()) {
                utente = new Utente(result.getString(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7),
                        result.getString(8));
                utenti.add(utente);
            }

        } catch (SQLException e) {
           // e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
               // rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
               // sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
               // cse.printStackTrace();
            }
        }

        return utenti;
    }

    @Override
    public Utente getUtente(String email) {
    	
    	
        Utente utente = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_QUERY);
            statement.setString(1, email);
            statement.execute();
            result = statement.getResultSet();

            if (result.next() && result != null) {
                utente = new Utente(result.getString(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7),
                        result.getString(8));
            }
        } catch (SQLException e) {
           // e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
              //  rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
               // sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
              //  cse.printStackTrace();
            }
        }


        return utente;
		

    }

    @Override
    public boolean createUtente(Utente utente) {

        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY);

            statement.setString(1, utente.getEmail());
            statement.setString(2, utente.getPassword());
            statement.setString(3, utente.getNome());
            statement.setString(4, utente.getCognome());
            statement.setString(5, utente.getDataNascita());
            statement.setString(6, utente.getTelefono());
            statement.setNull(7, Types.DATE);
            statement.setNull(8, Types.DATE);
            int check= statement.executeUpdate();

            if (check>1) {
                return true; //successo
            } else {
                return false;
            }
        } catch (SQLException e) {
           // e.printStackTrace();
        } finally {

            try {
                statement.close();
            } catch (Exception sse) {
              //  sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
               // cse.printStackTrace();
            }
        }

        return false;

    }

    @Override
    public boolean updateUtente(Utente utente) {

        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(UPDATE_QUERY);

            
            statement.setString(1,utente.getPassword());
            statement.setString(2, utente.getNome());
            statement.setString(3, utente.getCognome());
            statement.setString(4, utente.getDataNascita());
            statement.setString(5, utente.getTelefono());
            statement.setString(6,utente.getEmail());

            int check = statement.executeUpdate();

            if (check > 0) {
                return true;
            }

            else return false;


        } catch (SQLException e) {
            //e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
               // rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
               // sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
               // cse.printStackTrace();
            }
        }


        return false;


    }

    @Override
    public boolean deleteUtente(Utente utente) {
		return false;
    	/*
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(DELETE_QUERY);
            statement.setString(1, utente.getEmail());
            int check = statement.executeUpdate();

            if (check > 0) {
                return true;
            }

            else return false;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
        */
    }


    @Override
    public boolean addAbbonamento(String email, String durata) {

        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String fineAbbonamento="";

        String inizioAbbonamento = LocalDateTime.now().toInstant(ZoneOffset.UTC).toString();

        if(durata.equals("mensile")){
            fineAbbonamento =  LocalDateTime.now().plusMonths(1).toInstant(ZoneOffset.UTC).toString();
        }

        if(durata.equals("annuale")){
            fineAbbonamento =  LocalDateTime.now().plusYears(1).toInstant(ZoneOffset.UTC).toString();
        }

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(SUBSCRIBE_QUERY);

            statement.setString(1, inizioAbbonamento.substring(0,10));
            statement.setString(2, fineAbbonamento.substring(0,10));
            statement.setString(3, email);

            int check = statement.executeUpdate();

            if (check > 0) {
                return true;
            }

            else return false;


        } catch (SQLException e) {
            //e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
              //  rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
              //  sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
              //  cse.printStackTrace();
            }
        }


        return false;

    }
    
    public boolean emailAlreadyExists(String email) {
    	List<String> emails = new ArrayList<String>();
    	Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(GET_EMAILS);
            statement.execute();
            result = statement.getResultSet();

            while (result.next()) {
             String e = result.getString(1);
             emails.add(e);
             System.out.println(e);
            }
            
            for(int i=0; i < emails.size(); i++) {
            	if(email.equals(emails.get(i))) {
            		return true;
            	}
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

    	return false;
    }
}
