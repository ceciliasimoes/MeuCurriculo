package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FormacaoCadastrarDTO(
        @NotBlank String instituicao,
        @NotBlank String nomeFormacao,
        @NotBlank String tipoFormacao,
        @JsonFormat(pattern = "MM/yyyy")LocalDate dataInicio,
        @JsonFormat(pattern = "MM/yyyy")LocalDate dataTermino,
        @NotNull Long curriculoId
){
}
