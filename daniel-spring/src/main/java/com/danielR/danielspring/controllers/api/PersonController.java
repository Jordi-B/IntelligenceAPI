package com.danielR.danielspring.controllers.api;

import com.danielR.danielspring.models.Person;
import com.danielR.danielspring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()

@RequestMapping("/api/persons")
@CrossOrigin
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("")
    public List<Person> getAllPersons() {
        return this.personService.findAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable String id){
        Person result =this.personService.getPersonById(id);
        return result;
    }
}
