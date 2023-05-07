package com.op.springbootjpa.controller;

import com.op.springbootjpa.entity.Person;
import com.op.springbootjpa.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        return ResponseEntity.ok(personService.getAllPersons(firstName,lastName));
    }

    @PostMapping("/person")
    public ResponseEntity<Void> addPerson(@RequestBody Person person){
        personService.savePerson(person);
        return ResponseEntity.ok().build();
    }
}
