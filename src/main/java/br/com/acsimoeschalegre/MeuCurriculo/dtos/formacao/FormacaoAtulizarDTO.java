package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FormacaoAtulizarDTO(
        @NotNull Long id,
        String tipoFormacao,
        @JsonFormat(pattern = "MM/yyyy") LocalDate dataInicio,
        @JsonFormat(pattern = "MM/yyyy") LocalDate dataTermino
) {
}
