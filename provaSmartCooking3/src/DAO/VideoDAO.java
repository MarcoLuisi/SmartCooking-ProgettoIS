package DAO;

import Model.Utente;
import Model.Video;

import java.util.List;

public interface VideoDAO {

    /** Recupera tutti i video dal DB. */
    public List<Video> getAllVideo();

    /** Recupera tutti i video dal DB della categoria passata come parametro. */
    public List<Video> getVideoByCategoria(String categoria);

    /** Recupera tutti i Video dal DB dell'insegnante dal nome e dal cognome passati come parametro */
    public List<Video> getVideoByInsegnante(String nome, String cognome);
    
    /** Recupera tutti i Video dal DB in base alla keyword */
    public List<Video> getVideoByKeyword(String keyword);

    /** Aggiunge un oggetto Video al DB */
    public int createVideo(String titolo, String categoria, boolean gratuito,
                               int id_insegnante, String email_admin);

    /** Cancella un oggetto Video esistente. */
    public boolean deleteVideo (String titolo);

	public Video getVideo(String titolo);
	
	public boolean updateVideo (int id_video, String titolo, String categoria, boolean gratuito,
                               int id_insegnante, String email_admin);

}
