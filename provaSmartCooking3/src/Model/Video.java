package Model;

public class Video {

    private int idVideo;
    private String titolo;
    private String categoria;
    private boolean gratuito;
    private Admin admin;
    private int idinsegnante;
   // private Insegnante insegnante;
    private String urlVideo;
    private String urlFoto;

    public Video(){}

    public Video(int idVideo, String titolo, String categoria, boolean gratuito){
        setIdVideo(idVideo);
        setTitolo(titolo);
        setCategoria(categoria);
        setGratuito(gratuito);
    }


    public int getIdVideo() {
        return idVideo;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    /*
    public void setAdmin(Admin newAdmin){



        if (admin != newAdmin) {
            Admin old = admin;
            admin = newAdmin;
            if (newAdmin!= null)
                newAdmin.addVideo(this);
            if (old != null)
                old.removeVideo(this);
        }
    }*/

    /*
    public void setInsegnante(Insegnante newInsegnante){



        if (insegnante != newInsegnante) {
            Insegnante old = insegnante;
            insegnante = newInsegnante;
            if (newInsegnante!= null)
                newInsegnante.addVideo(this);
            if (old != null)
                old.removeVideo(this);
        }
    }*/

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
/*
    public Insegnante getInsegnante() {
        return insegnante;
    }
*/
    /*
    public Admin getAdmin() {
        return admin;
    }
*/
	public int getIdinsegnante() {
		return idinsegnante;
	}

	public void setIdinsegnante(int idinsegnante) {
		this.idinsegnante = idinsegnante;
	}
}
