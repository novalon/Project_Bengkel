package pojos;
// Generated Dec 2, 2018 10:20:07 AM by Hibernate Tools 4.3.1



/**
 * Location generated by hbm2java
 */
public class Location  implements java.io.Serializable {


     private long id;
     private Double lat;
     private Double lng;
     private String name;

    public Location() {
    }

	
    public Location(long id) {
        this.id = id;
    }
    public Location(long id, Double lat, Double lng, String name) {
       this.id = id;
       this.lat = lat;
       this.lng = lng;
       this.name = name;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Double getLat() {
        return this.lat;
    }
    
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {
        return this.lng;
    }
    
    public void setLng(Double lng) {
        this.lng = lng;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

public String toJson() {

        return "{\"lat\":" + getLat() + ",\"lng\":" + getLng() + ",\"name\":" + getName() +  "}";

    }



}


