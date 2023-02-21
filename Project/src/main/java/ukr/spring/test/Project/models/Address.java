package ukr.spring.test.Project.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "json" ,name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person1;
    @OneToOne(mappedBy = "address")
    private Geo geo;

    public Address(){

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
