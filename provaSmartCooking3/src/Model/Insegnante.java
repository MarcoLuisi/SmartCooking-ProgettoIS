/*
package Model;

import java.util.ArrayList;

public class Insegnante {
    private int idInsegnante;
    private String nome;
    private String cognome;
    private String ristorante;
    private ArrayList<Video> listvideo;

    
    public Insegnante(){}

    public Insegnante(int idInsegnante, String nome, String cognome, String ristorante){

        setIdInsegnante(idInsegnante);
        setNome(nome);
        setCognome(cognome);
        setRistorante(ristorante);
        listvideo=new ArrayList<Video>();

    }

    public int getIdInsegnante() {
        return idInsegnante;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getRistorante() {
        return ristorante;
    }

    public void setIdInsegnante(int idInsegnante) {
        this.idInsegnante = idInsegnante;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setRistorante(String ristorante) {
        this.ristorante = ristorante;
    }

    /*
    public void addVideo(Video v){
        listvideo.add(v);
        v.setInsegnante(this);
    }

    public void removeVideo(Video v){
        listvideo.remove(v);
        v.setInsegnante(null);
    }
    
}
*/