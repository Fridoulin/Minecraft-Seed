package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {


    //SINGLETON PATTERN
    private static DBManager instance = null;
    private DBManager(){}
    public static DBManager getInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }


    String pwd = "NicerSpeck#";
    String user = "root";

    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MinecraftSeed",user,pwd);
        return con;
    }

    public void releaseConnection(Connection con) throws SQLException{
        con.close();
    }

    public boolean canLogin(Connection con, String email, String pwd){
        String sql = "select count(*) as countx from benutzer where email = ? and passwort = ?";
        boolean success = false;
        try (PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, email);
            stm.setString(2, pwd);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                if(rs.getInt("countx") == 1){
                    success = true;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return success;
    }

    public String canRegister(Connection con, String email, String pwd, String vorname, String nachname){
        boolean success = false;
        if(!email.contains("@")){
            return "email";
        }
        if(pwd.contains(vorname) || pwd.contains(nachname)){
            return "vorna";
        }
        String sql = "insert into benutzer values (?,?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, email);
            stm.setString(2, vorname);
            stm.setString(3, nachname);
            stm.setString(4, pwd);
            stm.executeUpdate();
            success = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "ok";
    }

    public boolean insertSeed(Connection con, String seed, String beschreibung) {
        String sql = "insert into seedDB values (?,?)";
        boolean success = false;
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, seed);
            stm.setString(2, beschreibung);
            stm.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean getSeed(Connection con, String seed, String beschreibung){
        String sql = "select * as countx from benutzer where seed = ?";
        boolean success = false;
        try (PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, seed);
            stm.setString(2, beschreibung);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                if(rs.getInt("countx") == 1){
                    success = true;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return success;
    }

}
