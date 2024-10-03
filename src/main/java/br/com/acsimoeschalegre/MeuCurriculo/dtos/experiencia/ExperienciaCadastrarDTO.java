package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ExperienciaCadastrarDTO(
        @NotBlank String nomeEmpresa,
        @NotBlank String cargo,
        @NotNull LocalDate dataInicio,
        @JsonFormat(pattern = "MM/yyyy")LocalDate dataTermino,
        @NotBlank String cidade,
        @Size(min = 255, max = 600) String resumoDeAtividades,
        @NotNull Long curriculoId
) {
}
