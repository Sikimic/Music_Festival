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
// @ReturnParam - User from database  or null if not found 
   public static User doLogin(String username, String password) {
        List<User> res = new ArrayList<>();
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createSQLQuery("SELECT username, password, ime, prezime, telefon, email, repassword FROM user WHERE username = :username AND password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        res = query.list();
        session.getTransaction().commit();

        Iterator itr = res.iterator();
        User user = null;
        
        if(itr.hasNext()){
            user = new User();
            Object[] obj = (Object[]) itr.next();
            user.setUsername(String.valueOf(obj[0]));
            user.setPassword(String.valueOf(obj[1]));
            user.setIme(String.valueOf(obj[2]));
            user.setPrezime(String.valueOf(obj[3]));
            user.setTelefon(String.valueOf(obj[4]));
            user.setEmail(String.valueOf(obj[5]));
            user.setRepassword(String.valueOf(obj[6]));
        } 
        
        return user;
   }
 
// LoginBean - used for logging in the user
// @ReturnParam - User from database  or null if not found 
   public static int doRegister(User user) {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return 1;
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
