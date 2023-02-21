package ukr.spring.test.Project.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(schema = "json" ,name = "Geo")
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lat;
    private String lng;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "id=" + id +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", address=" + address +
                '}';
    }
}
