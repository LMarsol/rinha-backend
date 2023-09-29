package com.marsollu.rinhabackend.services;

import com.marsollu.rinhabackend.domain.Person;
import com.marsollu.rinhabackend.dto.PersonRequestDTO;
import com.marsollu.rinhabackend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person createPerson(PersonRequestDTO data) throws Exception {
        if(data.apelido().length() > 32) {
            throw new Exception("Apelido deve possuir no máximo 32 caracteres");
        }

        if(data.nome().length() > 100) {
            throw new Exception("Nome deve possuir no máximo 100 caracteres");
        }

        Person person = new Person(data);

        return this.repository.save(person);
    }

    public Person getPersonById(Long id) throws Exception {
        Optional<Person> person =  this.repository.findById(id);

        if(person.isPresent()) {
            return person.get();
        } else {
            throw new Exception("No person found with id");
        }
    }

    public long getAllCount() {
        return this.repository.count();
    }
}
