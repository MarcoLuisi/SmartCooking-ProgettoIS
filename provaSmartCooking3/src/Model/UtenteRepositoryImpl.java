package Model;

import DAO.MySQLUtenteDAO;

import java.util.List;

public class UtenteRepositoryImpl implements UtenteRepository {

    private MySQLUtenteDAO mySQLUtenteDAO;

    public UtenteRepositoryImpl(){
        mySQLUtenteDAO=new MySQLUtenteDAO();
    }


    @Override
    public List<Utente> getList() {
        return mySQLUtenteDAO.getAllUtenti();
    }

    @Override
    public Utente getUtente(String email) {
      return mySQLUtenteDAO.getUtente(email);
    }

    @Override
    public boolean addUtente(Utente utente) {
        return mySQLUtenteDAO.createUtente(utente);
    }

    @Override
    public boolean updateUtente(Utente utente) {
        return mySQLUtenteDAO.updateUtente(utente);
    }

    @Override
    public boolean removeUtente(Utente utente) {
       return mySQLUtenteDAO.deleteUtente(utente);
    }

    @Override
    public boolean abbonamentoUtente(String email, String durata) {
        return mySQLUtenteDAO.addAbbonamento(email, durata);
    }
}
