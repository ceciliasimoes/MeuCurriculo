package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import com.fasterxml.jackson.annotation.JsonFormat;


public record FormacaoAtulizarDTO(
        String tipoFormacao,
        @JsonFormat(pattern = "MM/yyyy/dd") String dataInicio,
        @JsonFormat(pattern = "MM/yyyy/dd") String dataTermino
) {
}
