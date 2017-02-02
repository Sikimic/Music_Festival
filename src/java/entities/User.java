package entities;
// Generated Feb 2, 2017 3:52:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="music_fest"
)
public class User  implements java.io.Serializable {


     private String username;
     private String password;
     private String ime;
     private String prezime;
     private String telefon;
     private String email;
     private String repassword;

    public User() {
    }

    public User(String username, String password, String ime, String prezime, String telefon, String email, String repassword) {
       this.username = username;
       this.password = password;
       this.ime = ime;
       this.prezime = prezime;
       this.telefon = telefon;
       this.email = email;
       this.repassword = repassword;
    }
   
     @Id 

    
    @Column(name="username", unique=true, nullable=false, length=16)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=16)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="ime", nullable=false, length=16)
    public String getIme() {
        return this.ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }

    
    @Column(name="prezime", nullable=false, length=16)
    public String getPrezime() {
        return this.prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    
    @Column(name="telefon", nullable=false, length=16)
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    
    @Column(name="email", nullable=false, length=16)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="repassword", nullable=false, length=16)
    public String getRepassword() {
        return this.repassword;
    }
    
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }




}

