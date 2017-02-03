package entities;
// Generated Feb 3, 2017 5:23:20 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Socialnetwork generated by hbm2java
 */
@Entity
@Table(name="socialnetwork"
    ,catalog="music_fest"
)
public class Socialnetwork  implements java.io.Serializable {


     private Integer idn;
     private String name;
     private String link;
     private int idf;

    public Socialnetwork() {
    }

    public Socialnetwork(String name, String link, int idf) {
       this.name = name;
       this.link = link;
       this.idf = idf;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDN", unique=true, nullable=false)
    public Integer getIdn() {
        return this.idn;
    }
    
    public void setIdn(Integer idn) {
        this.idn = idn;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="link", nullable=false)
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }

    
    @Column(name="IDF", nullable=false)
    public int getIdf() {
        return this.idf;
    }
    
    public void setIdf(int idf) {
        this.idf = idf;
    }




}

