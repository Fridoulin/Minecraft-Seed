package models;

import java.sql.Connection;

import javax.servlet.ServletException;

public class RegisterService {

    private static RegisterService instance = null;
    private RegisterService(){}
    public static RegisterService getInstance(){
        if(instance == null){
            instance = new RegisterService();
        }
        return instance;
    }

    public String canRegister(String email, String pwd, String vorname, String nachname) throws ServletException{

        DBManager db = DBManager.getInstance();
        Connection con = null;
        try{
            con = db.getConnection();
            return db.canRegister(con, email, pwd, vorname, nachname);
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
