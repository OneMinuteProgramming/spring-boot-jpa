package com.op.springbootjpa.service;

import com.op.springbootjpa.entity.Person;
import com.op.springbootjpa.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPersons(String firstName, String lastName){
        if(StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName)){
            return personRepository.findAllPersonByFullNameIgnoreCase(firstName,lastName);
        } else if (StringUtils.isNotBlank(firstName)) {
            return personRepository.findAllPersonByFirstNameIgnoreCase(firstName);
        } else if (StringUtils.isNotBlank(lastName)) {
            return personRepository.findAllPersonByLastNameIgnoreCase(lastName);
        }

        return personRepository.findAll();
    }
}
