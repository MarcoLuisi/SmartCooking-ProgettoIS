package DAO;

import Model.Admin;
import Model.Utente;

import java.util.List;

public interface AdminDAO {

    /** Recupera tutti gli admin dal DB. */
    public List<Admin> getAllAdmin();
}
