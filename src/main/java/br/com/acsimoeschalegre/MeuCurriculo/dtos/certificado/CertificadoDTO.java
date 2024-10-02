package br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado;

import br.com.acsimoeschalegre.MeuCurriculo.models.Certificado;

public record CertificadoDTO(
        Long id,
        String nomeCertificado,
        String instituicao,
        int quantidadeHoras,
        String resumoDeAtividades
) {
    public CertificadoDTO(Certificado certificado) {
        this(certificado.getId(), certificado.getNomeCertificado(), certificado.getInstituicao(),
                certificado.getQuantidadeHoras(), certificado.getResumoDeAtividades());
    }
}