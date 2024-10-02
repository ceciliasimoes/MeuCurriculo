package br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CurriculoCadastrarDTO(
        @NotBlank String nome,
        @NotBlank String localidade,
        @Size(min = 255, max = 600) String objetivoProfissional,
        @NotNull List<String> meiosDeContato,
        List<String> competencias
) {
}
