/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.AppController;
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
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.*;
import utils.DatabaseHelper;
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
    private String new_pass;
    private User user;
    
    public LoginBean() {
        user = new User();
    }
    
    public String doLogin() {
        String ret = "";
        List<User> res = new ArrayList<>();
        
        res = DatabaseHelper.doLogin(username, password);
        
        Iterator itr = res.iterator();
        if(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            user.setUsername(String.valueOf(obj[0]));
            user.setPassword(String.valueOf(obj[1]));
            user.setIme(String.valueOf(obj[2]));
            user.setPrezime(String.valueOf(obj[3]));
            user.setTelefon(String.valueOf(obj[4]));
            user.setEmail(String.valueOf(obj[5]));
            user.setRepassword(String.valueOf(obj[6]));
            
            AppController.setUser(user);
            ret = "homePage";
        }
        return ret;
    }
    
    public String doRegister() {
        String ret = "";
       
        return ret;
    }
    
    public String doChangePassword() {
        String ret = "";
        int res = DatabaseHelper.doUserChangePassword(username, password, new_pass);
        if (res == 1) ret = "index";
        
        return ret;
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
    
    public String getNewPass() {
        return new_pass;
    }

    public void setNewPass(String new_pass) {
        this.new_pass = new_pass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
