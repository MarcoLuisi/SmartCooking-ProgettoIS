package DAO;

import Model.Admin;
import Model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdminDAO implements AdminDAO{

    /** La query per la lettura di tutti gli utenti. */
    private static final String READ_ALL_QUERY = "SELECT * FROM amministratore";


    @Override
    public List<Admin> getAllAdmin() {

        List<Admin> admins = new ArrayList<Admin>();
        Admin admin = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_ALL_QUERY);
            statement.execute();
            result = statement.getResultSet();

            while(result.next()) {
                admin = new Admin(result.getString(1), result.getString(2));
                admins.add(admin);
            }

        } catch (SQLException e) {
           // e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
               // rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
               // sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
               // cse.printStackTrace();
            }
        }
        return admins;
    }
}
