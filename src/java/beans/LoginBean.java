/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author Sikimic Nebojsa
 */
@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean {
    private String username;
    private String password;
    private User user;
    
    public LoginBean() {
        user = new User();
    }
    
    public String doLogin() {
        String res = "";
        
        Connection conn = DB.getInstance().getConnection();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM user WHERE username= '" + username +"' AND password = '" + password +"'";
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                user.setEmail(rs.getString("email"));
                user.setIme(rs.getString("ime"));
                user.setPassword(password);
                user.setPrezime("prezime");
                user.setRepassword(password);
                user.setTelefon(rs.getString("telefon"));
                user.setUsername(username);
                
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("user", user);
                res = "homePage";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            DB.getInstance().putConnection(conn);
        }
        return res;
    }
    
    public String doRegister() {
        String res = "";
        if (!user.getPassword().equals(user.getRepassword())) return res;
        Connection conn = DB.getInstance().getConnection();
        try {
            
            String query = "INSERT INTO user (username,password,ime,prezime,telefon,email,repassword) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getIme());
            stmt.setString(4, user.getPrezime());
            stmt.setString(5, user.getTelefon());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getPassword());
            stmt.execute();
               
            res = "index";
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            DB.getInstance().putConnection(conn);
        }
        return res;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
