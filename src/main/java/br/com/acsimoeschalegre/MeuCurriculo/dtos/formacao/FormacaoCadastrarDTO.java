package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record FormacaoCadastrarDTO(
        @NotBlank String instituicao,
        @NotBlank String nomeFormacao,
        @NotBlank String tipoFormacao,
        @JsonFormat(pattern = "MM/yyyy/dd")String dataInicio,
        @JsonFormat(pattern = "MM/yyyy/dd")String dataTermino,
        @NotNull Long curriculoId
){
}
