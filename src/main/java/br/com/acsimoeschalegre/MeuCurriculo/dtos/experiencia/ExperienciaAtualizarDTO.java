package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ExperienciaAtualizarDTO(
        @NotNull Long id,
        @JsonFormat(pattern = "MM/yyyy") LocalDate dataInicio,
        @JsonFormat(pattern = "MM/yyyy") LocalDate dataTermino,
        String cidade,
        @Size(min = 255, max = 600) String resumoDeAtividades
) {
}
