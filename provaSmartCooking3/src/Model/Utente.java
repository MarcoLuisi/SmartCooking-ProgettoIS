package Model;

public class Utente {

    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String telefono;
    private String inizioAbbonamento;
    private String fineAbbonamento;

    public Utente(){

    }

    public Utente(String email, String password, String nome, String cognome,
                  String dataNascita, String telefono, String inizioAbbonamento, String fineAbbonamento){

        setEmail(email);
        setPassword(password);
        setNome(nome);
        setCognome(cognome);
        setDataNascita(dataNascita);
        setTelefono(telefono);
        setInizioAbbonamento(inizioAbbonamento);
        setFineAbbonamento(fineAbbonamento);

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getInizioAbbonamento() {
        return inizioAbbonamento;
    }

    public String getFineAbbonamento() {
        return fineAbbonamento;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setInizioAbbonamento(String inizioAbbonamento) {
        this.inizioAbbonamento = inizioAbbonamento;
    }

    public void setFineAbbonamento(String fineAbbonamento) {
        this.fineAbbonamento = fineAbbonamento;
    }

    /*
    public void sottoscriviAbbonamento(String inizioAbbonamento, String fineAbbonamento){
        setInizioAbbonamento(inizioAbbonamento);
        setFineAbbonamento(fineAbbonamento);
    }

    public boolean isAbbonato(){

        if(inizioAbbonamento==null || inizioAbbonamento.equals("")) return false;

        if(fineAbbonamento==null || fineAbbonamento.equals("")) return false;

        return true;
    }
    */

}

