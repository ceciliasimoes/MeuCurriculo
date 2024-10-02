package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FormacaoCadastroDTO(
        @NotBlank String instituicao,
        @NotBlank String nomeFormacao,
        @NotBlank String tipoFormacao,
        LocalDate dataInicio,
        LocalDate dataTermino
){
}
