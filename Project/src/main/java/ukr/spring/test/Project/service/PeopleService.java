package ukr.spring.test.Project.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ukr.spring.test.Project.models.Person;
import ukr.spring.test.Project.repositories.PersonRepository;

import java.util.List;
@Transactional(readOnly = true)
@Service
public class PeopleService {

    private final PersonRepository personRepository;

    @Autowired
    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
}
