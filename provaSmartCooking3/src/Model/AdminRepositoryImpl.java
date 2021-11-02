package Model;

import DAO.MySQLAdminDAO;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository{
    private MySQLAdminDAO mySQLAdminDAO;

    public AdminRepositoryImpl(){
        mySQLAdminDAO=new MySQLAdminDAO();
    }

    @Override
    public List<Admin> getList() {
        return mySQLAdminDAO.getAllAdmin();
    }
}
