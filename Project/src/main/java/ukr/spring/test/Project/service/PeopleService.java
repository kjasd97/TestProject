package ukr.spring.test.Project.service;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ukr.spring.test.Project.dto.AddressDTO;
import ukr.spring.test.Project.dto.CompanyDTO;
import ukr.spring.test.Project.dto.PersonDTO;
import ukr.spring.test.Project.models.Address;
import ukr.spring.test.Project.models.Company;
import ukr.spring.test.Project.models.Geo;
import ukr.spring.test.Project.models.Person;
import ukr.spring.test.Project.repositories.PersonRepository;

import java.util.List;
@Transactional(readOnly = true)
@Service
public class PeopleService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PeopleService(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public void saveAll(List<Person> personList){
        personRepository.saveAll(personList);
    }

    @Transactional
    public void save (Person person){
       personRepository.save(person);

    }


//    public Person convertToPerson(PersonDTO personDTO){
//
//        CompanyDTO companyDTO = new CompanyDTO();
//        Company company = modelMapper.map(companyDTO, Company.class);
//
//        AddressDTO addressDTO = new AddressDTO();
//        Address address = modelMapper.map(addressDTO, Address.class);
//
//        Person person =  modelMapper.map(personDTO, Person.class);
//        address.setStreet(addressDTO.getStreet());
//        address.setSuite(addressDTO.getSuite());
//        address.setCity(addressDTO.getCity());
//        address.setZipcode(addressDTO.getZipcode());
//        person.setAddress(address);
//
//        company.setName(companyDTO.getName());
//        company.setBs(companyDTO.getBs());
//        company.setCatchPhrase(companyDTO.getCatchPhrase());
//        person.setCompany(company);
//
//        return person;
//    }
}
