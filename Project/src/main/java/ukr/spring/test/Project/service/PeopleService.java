package ukr.spring.test.Project.service;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ukr.spring.test.Project.dto.AddressDTO;
import ukr.spring.test.Project.dto.CompanyDTO;
import ukr.spring.test.Project.dto.PersonDTO;
import ukr.spring.test.Project.dto.PostDTO;
import ukr.spring.test.Project.models.*;
import ukr.spring.test.Project.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public Person convertToPerson (PersonDTO personDTO){
        return modelMapper.map(personDTO, Person.class);
    }

    public List <Person> convertToPeople(List <PersonDTO> personDTOS){
        return personDTOS.stream().map(personDTO -> modelMapper.map(personDTO , Person.class)).
                collect(Collectors.toList());
    }

}
