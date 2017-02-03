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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sikimic Nebojsa
 */
public class DatabaseHelper {
    
// LoginBean - used for logging in the user
// @ReturnParam - User from database  or null if not found 
   public static User doLogin(String username, String password) {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        List<User> users = criteria.list();
        
        session.getTransaction().commit();
        
        if (users.isEmpty()) return null;
        else return users.get(0);
   }
 
// LoginBean - used for registering the user
// @ReturnParam - 0 for unsuccesfull, 1 for successful update 
   public static int doRegister(User user) {
        Session session = HibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return 1;
   }
   
   
   
// LoginBean - used for updating the user password
// @ReturnParam - 0 for unsuccessfull, 1 for successfull update
   public static int doUserChangePassword(String username, String password, String new_pass) {
       
        User user = doLogin(username, password);
        if (user != null) {
            Session session = HibernateHelper.getSessionFactory().getCurrentSession();
            session.beginTransaction();
             
            user.setPassword(new_pass);
            user.setRepassword(new_pass);
            session.update(user);
            
            session.getTransaction().commit();
            return 1;
        }
        
        
        return 0;
   }   
    
}
