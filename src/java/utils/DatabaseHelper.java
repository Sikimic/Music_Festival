/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sikimic Nebojsa
 */
public class DatabaseHelper {
    
// LoginBean - used for logging in the user
// @ReturnParam - List of users from database   
   public static List<User> doLogin(String user, String pass) {
        List<User> res = new ArrayList<>();
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createSQLQuery("SELECT username, password, ime, prezime, telefon, email, repassword FROM user WHERE username = :username AND password = :password");
        query.setParameter("username", user);
        query.setParameter("password", pass);
        
        res = query.list();
        session.getTransaction().commit();
        
        return res;
   }
 
// LoginBean - used for updating the user password
// @ReturnParam - 0 for unsuccessfull, 1 for successfull update
   public static int doUserChangePassword(String user, String pass, String new_pass) {
       
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createSQLQuery("UPDATE user SET password = :pass , repassword = :repass WHERE username = :username AND password = :password");
        query.setParameter("username", user);
        query.setParameter("password", pass);
        query.setParameter("pass", new_pass);
        query.setParameter("repass", new_pass);
        
        int res = query.executeUpdate();
        session.getTransaction().commit();
        
        return res;
   }   
    
}
