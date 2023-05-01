package com.op.springbootjpa.service;

import com.op.springbootjpa.entity.Person;
import com.op.springbootjpa.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
}
