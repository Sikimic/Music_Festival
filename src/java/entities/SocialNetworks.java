package entities;
// Generated Feb 15, 2017 4:20:23 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SocialNetworks generated by hbm2java
 */
@Entity
@Table(name="social_networks"
    ,catalog="pia_project_db"
)
public class SocialNetworks  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String link;
     private int idFest;

    public SocialNetworks() {
    }

    public SocialNetworks(String name, String link, int idFest) {
       this.name = name;
       this.link = link;
       this.idFest = idFest;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    
    @Column(name="id_fest", nullable=false)
    public int getIdFest() {
        return this.idFest;
    }
    
    public void setIdFest(int idFest) {
        this.idFest = idFest;
    }




}

