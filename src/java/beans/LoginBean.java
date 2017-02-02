/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.AppController;
import DB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import entities.User;

import org.hibernate.Session;
import org.hibernate.*;
import utils.HibernateHelper;


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
        List<Object> list = new ArrayList<>();
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        
        Query query = session.createQuery("SELECT username, password, ime, prezime, telefon, email, repassword FROM user WHERE username = :username AND password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        list = query.list();
        if (list != null) {
            session.getTransaction().commit();
            user.setUsername((String)list.get(0));
            user.setPassword((String)list.get(1));
            user.setIme((String)list.get(2));
            user.setPrezime((String)list.get(3));
            user.setTelefon((String)list.get(4));
            user.setEmail((String)list.get(5));
            user.setRepassword((String)list.get(6));
            res = "homePage";
        } 
       

        return res;
    }
    
    public String doRegister() {
        String res = "";
       
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
