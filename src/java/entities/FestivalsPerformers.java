package entities;
// Generated Feb 15, 2017 4:20:23 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FestivalsPerformers generated by hbm2java
 */
@Entity
@Table(name="festivals_performers"
    ,catalog="pia_project_db"
)
public class FestivalsPerformers  implements java.io.Serializable {


     private Integer id;
     private int idFest;
     private int idPerformer;
     private Date date;
     private Date time;

    public FestivalsPerformers() {
    }

    public FestivalsPerformers(int idFest, int idPerformer, Date date, Date time) {
       this.idFest = idFest;
       this.idPerformer = idPerformer;
       this.date = date;
       this.time = time;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="id_fest", nullable=false)
    public int getIdFest() {
        return this.idFest;
    }
    
    public void setIdFest(int idFest) {
        this.idFest = idFest;
    }

    
    @Column(name="id_performer", nullable=false)
    public int getIdPerformer() {
        return this.idPerformer;
    }
    
    public void setIdPerformer(int idPerformer) {
        this.idPerformer = idPerformer;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date", nullable=false, length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="time", nullable=false, length=8)
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }




}

