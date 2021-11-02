package Model;

import java.util.ArrayList;

public class Admin {

    private String email;
    private String password;
    private ArrayList<Video> listvideo;

    public Admin(){}

    public Admin(String email, String password){

        setEmail(email);
        setPassword(password);
        listvideo=new ArrayList<Video>();

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    public void addVideo(Video v){
        listvideo.add(v);
        v.setAdmin(this);
    }

    public void removeVideo(Video v){
        listvideo.remove(v);
        v.setAdmin(null);
    }*/
}
