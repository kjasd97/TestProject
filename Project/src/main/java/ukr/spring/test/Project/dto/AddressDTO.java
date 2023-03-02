package ukr.spring.test.Project.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ukr.spring.test.Project.models.Geo;

public class AddressDTO {

    private int id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geoDTO;

    public AddressDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public GeoDTO getGeoDTO() {
        return geoDTO;
    }

    public void setGeoDTO(GeoDTO geoDTO) {
        this.geoDTO = geoDTO;
    }




}
