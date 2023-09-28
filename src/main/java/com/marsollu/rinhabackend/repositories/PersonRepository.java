package com.marsollu.rinhabackend.repositories;

import com.marsollu.rinhabackend.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
