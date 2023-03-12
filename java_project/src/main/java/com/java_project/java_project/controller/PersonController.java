package com.java_project.java_project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.java_project.java_project.data.Person;
import com.java_project.java_project.services.PersonService;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
   
    Person person;

    @GetMapping("/people")
    //getting all people!
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    //getting person by their id
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
        Person person = personService.getPersonById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // adding a person
    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
        
    }
    //updating persons data
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person updatedPerson) {
        Person person = personService.getPersonById(id);
        if (person != null) {
            updatedPerson.setId(id);
            personService.updatePerson(id, updatedPerson);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //deleting a person
    @DeleteMapping("/person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") int id) {
        Person person = personService.getPersonById(id);
        if (person != null) {
            personService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
