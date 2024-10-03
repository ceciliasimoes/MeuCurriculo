package br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CertificadoAtualizarDTO(
        String nomeCertificado,
        String instituicao,
        Integer quantidadeHoras,
        @Size(min = 255, max = 600) String resumoDeAtividades
) {
}
