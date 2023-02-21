package ukr.spring.test.Project.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Geo")
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lat;
    private String lng;


    public Geo (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


    @Override
    public String toString() {
        return "Geo{" +
                "id=" + id +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\''  +
                '}';
    }
}
