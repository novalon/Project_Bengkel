package pojos;
// Generated Nov 22, 2018 12:03:11 PM by Hibernate Tools 4.3.1



/**
 * Service generated by hbm2java
 */
public class Service  implements java.io.Serializable {


     private int noAntrian;

    public Service() {
    }

    public Service(int noAntrian) {
       this.noAntrian = noAntrian;
    }
   
    public int getNoAntrian() {
        return this.noAntrian;
    }
    
    public void setNoAntrian(int noAntrian) {
        this.noAntrian = noAntrian;
    }

    public String toJson() {
        return "{\"no Antrian\":" + getNoAntrian()+  "}";
 }




}


