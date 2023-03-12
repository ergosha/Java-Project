package com.java_project.java_project.services;
import com.java_project.java_project.data.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class PersonService {

    private List<Person> people = new ArrayList<>();

    //The methods of getting all people, getting by id, adding a person, updating a person, deleting a person
    public List<Person> getAllPeople() {
        return people;
    }

    public Person getPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void updatePerson(int id, Person updatedPerson) {
        for (Person person : people) {
            if (person.getId() == id) {
                person.setName(updatedPerson.getName());
                person.setAge(updatedPerson.getAge());
                person.setAddress(updatedPerson.getAddress());
                person.setPhoneNumber(updatedPerson.getPhoneNumber());
            }
        }
    }

    public void deletePerson(int id) {
        people.removeIf(person -> person.getId() == id);
    }

}
