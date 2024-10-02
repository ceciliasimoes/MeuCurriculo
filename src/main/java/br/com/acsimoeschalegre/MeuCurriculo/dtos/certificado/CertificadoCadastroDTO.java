package br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CertificadoCadastroDTO(
        @NotBlank String nomeCertificado,
        @NotBlank String instituicao,
        @NotNull int quantidadeHoras,
        @Size(min = 255, max = 600) String resumoDeAtividades
) {
}