package com.op.springbootjpa.controller;

import com.op.springbootjpa.entity.Person;
import com.op.springbootjpa.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons(){
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PostMapping("/person")
    public ResponseEntity<Void> addPerson(@RequestBody Person person){
        personService.savePerson(person);
        return ResponseEntity.ok().build();
    }
}
