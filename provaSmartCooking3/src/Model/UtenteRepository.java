package Model;

import java.util.List;

public interface UtenteRepository {

    List<Utente> getList();
    Utente getUtente(String email);
    boolean addUtente(Utente utente);
    boolean updateUtente(Utente utente);
    boolean removeUtente(Utente utente);
    boolean abbonamentoUtente(String email, String durata);


}
