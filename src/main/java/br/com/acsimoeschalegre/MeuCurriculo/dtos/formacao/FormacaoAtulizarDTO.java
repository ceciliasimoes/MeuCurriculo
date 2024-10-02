package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import jakarta.validation.constraints.NotNull;

public record FormacaoAtulizarDTO(
        @NotNull Long id,
        String tipoFormacao,
        String dataInicio,
        String dataTermino
) {
}
