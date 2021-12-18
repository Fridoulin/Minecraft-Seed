package models;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class EingabeSeedService{

    //SINGLETON PATTERN
    private static EingabeSeedService instance = null;
    private EingabeSeedService(){}
    public static EingabeSeedService getInstance(){
        if(instance == null){
            instance = new EingabeSeedService();
        }
        return instance;
    }

    public boolean canInputSeed(String seed, String beschreibung) throws ServletException{

        DBManager db = DBManager.getInstance();
        Connection con = null;
        try{
            con = db.getConnection();
            return db.insertSeed(con, seed, beschreibung);

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
    public boolean getSeed(String seed, String beschreibung) throws ServletException{

        DBManager db = DBManager.getInstance();
        Connection con = null;
        try{
            con = db.getConnection();
            return db.canLogin(con, seed, beschreibung);

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
