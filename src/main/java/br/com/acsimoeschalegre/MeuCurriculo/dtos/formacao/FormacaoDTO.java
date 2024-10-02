package br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao;

import br.com.acsimoeschalegre.MeuCurriculo.models.Formacao;

import java.time.LocalDate;

public record FormacaoDTO(
         Long id,
         Long curriculoId,
         String instituicao,
         String nomeFormacao,
         String tipoFormacao,
         String dataInicio ,
         String dataTermino
) {

    public FormacaoDTO(Formacao formacao) {
        this(formacao.getId(),
                formacao.getCurriculo().getId(),
                formacao.getInstituicao(),
                formacao.getNomeFormacao(),
                formacao.getTipoFormacao(),
                formacao.getDataInicio(),
                formacao.getDataTermino());
    }
}
