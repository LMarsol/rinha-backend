package com.marsollu.rinhabackend.controllers;

import com.marsollu.rinhabackend.domain.Person;
import com.marsollu.rinhabackend.dto.PersonRequestDTO;
import com.marsollu.rinhabackend.dto.PersonResponseDTO;
import com.marsollu.rinhabackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@RequestBody PersonRequestDTO data) throws Exception {
        Person person = service.createPerson(data);
        List<String> stack = person.getStack() != null ? Arrays.stream(person.getStack().split(";")).toList() : null;
        PersonResponseDTO response = new PersonResponseDTO(person.getId(), person.getNickname(), person.getName(), person.getBirth_date(), stack);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> get(@PathVariable("id") int personId) throws Exception {
        Person person = service.getPersonById((long) personId);
        List<String> stack = person.getStack() != null ? Arrays.stream(person.getStack().split(";")).toList() : null;
        PersonResponseDTO data = new PersonResponseDTO(person.getId(), person.getNickname(), person.getName(), person.getBirth_date(), stack);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/contagem-pessoas")
    public long count() {
        return service.getAllCount();
    }
}
