package com.marsollu.rinhabackend.domain;

import com.marsollu.rinhabackend.dto.PersonRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "persons")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nickname;
    private String name;
    private String birth_date;
    private String stack;

    public Person(PersonRequestDTO data) {
        this.nickname = data.apelido();
        this.name = data.nome();
        this.birth_date = data.nascimento();
        this.stack = data.stack() != null ? String.join(";", data.stack()) : null;
    }
}
