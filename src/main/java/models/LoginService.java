package models;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class LoginService {

    //SINGLETON PATTERN
    private static LoginService instance = null;
    private LoginService(){}
    public static LoginService getInstance(){
        if(instance == null){
            instance = new LoginService();
        }
        return instance;
    }

    public boolean canLogin(String email, String pwd) throws ServletException{

        DBManager db = DBManager.getInstance();
        Connection con = null;
        try{
            con = db.getConnection();
            return db.canLogin(con, email, pwd);

        }
        catch(Exception e){
            throw new ServletException(e.getMessage());
        }
        finally{
            if (con != null){
                try {
                    db.releaseConnection(con);
                } catch (Exception e) {
                    throw new ServletException(e.getMessage());
                }
            }
        }
    }
}
