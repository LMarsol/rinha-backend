package com.marsollu.rinhabackend.controllers;

import com.marsollu.rinhabackend.domain.Person;
import com.marsollu.rinhabackend.dto.PersonRequestDTO;
import com.marsollu.rinhabackend.dto.PersonResponseDTO;
import com.marsollu.rinhabackend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping
    public HttpStatus create(@RequestBody PersonRequestDTO data) {
        Person person = new Person(data);
        repository.save(person);
        return HttpStatus.CREATED;
    }

    @GetMapping("/{id}")
    public PersonResponseDTO get(@PathVariable("id") int personId) {
        Person person = repository.getReferenceById((long) personId);

        return new PersonResponseDTO(person.getId(), person.getNickname(), person.getName(), person.getBirth_date());
    }

    @GetMapping()
    public PersonResponseDTO search(@RequestParam("t") String search) {
        System.out.println(search);

        return new PersonResponseDTO((long) 1, "Search", "Lucas Marsol", "1998-07-01");
    }

}
