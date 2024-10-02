package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ExperienciaAtualizarDTO(
        @NotNull Long id,
        LocalDate dataInicio,
        LocalDate dataTermino,
        String cidade,
        @Size(min = 255, max = 600) String resumoDeAtividades
) {
}
