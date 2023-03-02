package ukr.spring.test.Project.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ukr.spring.test.Project.dto.PersonDTO;
import ukr.spring.test.Project.models.Person;
import ukr.spring.test.Project.models.Post;
import ukr.spring.test.Project.repositories.PersonRepository;
import ukr.spring.test.Project.service.PeopleService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("people")
public class PersonController {

private final PeopleService peopleService;

    @Autowired
    public PersonController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @PutMapping
    public ResponseEntity<Void> createPeople(@RequestBody List <PersonDTO> personDTOS){
        List<Person> persons = peopleService.convertToPeople(personDTOS);
        peopleService.saveAll(persons);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody Person person) {
        peopleService.save(person);
        return ResponseEntity.ok().build();
    }


}
