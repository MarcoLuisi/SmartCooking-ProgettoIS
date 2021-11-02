package Model;

import java.util.List;

public interface VideoRepository {

    List<Video> getList();
    List<Video> getListByCategoria(String categoria);
    List<Video> getListByInsegnante(String nome, String cognome);
    List<Video> getListByKeyword(String keyword);
    int addVideo(String titolo, String categoria, boolean gratuito,
                int id_insegnante, String email_admin);
    boolean removeVideo(String titolo);
    boolean modifyVideo(int id_video, String titolo, String categoria, boolean gratuito,
            int id_insegnante, String email_admin);
    Video getVideo(String titolo);

}
