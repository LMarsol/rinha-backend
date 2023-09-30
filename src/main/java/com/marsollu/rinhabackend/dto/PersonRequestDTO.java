package com.marsollu.rinhabackend.dto;

import java.util.List;

public record PersonRequestDTO(String apelido, String nome, String nascimento, List<String> stack) {
}
