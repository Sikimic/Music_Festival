package entities;
// Generated Feb 15, 2017 4:20:23 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ReservationsId generated by hbm2java
 */
@Embeddable
public class ReservationsId  implements java.io.Serializable {


     private String username;
     private int idTicket;

    public ReservationsId() {
    }

    public ReservationsId(String username, int idTicket) {
       this.username = username;
       this.idTicket = idTicket;
    }
   


    @Column(name="username", nullable=false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name="id_ticket", nullable=false)
    public int getIdTicket() {
        return this.idTicket;
    }
    
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ReservationsId) ) return false;
		 ReservationsId castOther = ( ReservationsId ) other; 
         
		 return ( (this.getUsername()==castOther.getUsername()) || ( this.getUsername()!=null && castOther.getUsername()!=null && this.getUsername().equals(castOther.getUsername()) ) )
 && (this.getIdTicket()==castOther.getIdTicket());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUsername() == null ? 0 : this.getUsername().hashCode() );
         result = 37 * result + this.getIdTicket();
         return result;
   }   


}

