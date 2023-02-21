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
import ukr.spring.test.Project.models.Person;
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


//   @GetMapping()
//    public void json(){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://jsonplaceholder.typicode.com/users/1";
//        Person person = restTemplate.getForObject(url, Person.class);
//        peopleService.save(person);
//    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Person person){

        peopleService.save(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
