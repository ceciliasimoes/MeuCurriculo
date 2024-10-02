package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ExperienciaCadastrarDTO(
        @NotBlank String nomeEmpresa,
        @NotBlank String cargo,
        @NotNull LocalDate dataInicio,
        LocalDate dataTermino,
        @NotBlank String cidade,
        @Size(min = 255, max = 600) String resumoDeAtividades
) {
}
