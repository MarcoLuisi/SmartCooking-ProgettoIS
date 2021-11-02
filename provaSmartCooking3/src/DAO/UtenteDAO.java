package DAO;

import Model.Utente;

import java.util.List;

public interface UtenteDAO {

    /** Recupera tutti gli utenti dal DB. */
    public List<Utente> getAllUtenti();

    /** Recupera un oggetto Utente esistente a partire dall'email. */
    public Utente getUtente(String email);

    /** Crea un oggetto Utente e restituisce l'email. */
    public boolean createUtente(Utente utente);

    /** Aggiorna un oggetto Utente esistente. */
    public boolean updateUtente(Utente utente);

    /** Cancella un oggetto Utente esistente. */
    public boolean deleteUtente(Utente utente);

    /**Aggiunge l'abbonamento all'oggetto Utente esistente */
    public boolean addAbbonamento(String email, String durata);


}
