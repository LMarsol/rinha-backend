package com.marsollu.rinhabackend.controllers;

import com.marsollu.rinhabackend.domain.Person;
import com.marsollu.rinhabackend.dto.PersonRequestDTO;
import com.marsollu.rinhabackend.dto.PersonResponseDTO;
import com.marsollu.rinhabackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody PersonRequestDTO data) throws Exception {
        Person newPerson = service.createPerson(data);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> get(@PathVariable("id") int personId) throws Exception {
        Person person = service.getPersonById((long) personId);
        PersonResponseDTO data = new PersonResponseDTO(person.getId(), person.getNickname(), person.getName(), person.getBirth_date());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/contagem-pessoas")
    public long count() {
        return service.getAllCount();
    }
}
