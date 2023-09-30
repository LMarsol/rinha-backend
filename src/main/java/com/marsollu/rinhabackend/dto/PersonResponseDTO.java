package com.marsollu.rinhabackend.dto;

import java.util.List;

public record PersonResponseDTO(Long id, String apelido, String nome, String nascimento, List<String> stack) {
}
