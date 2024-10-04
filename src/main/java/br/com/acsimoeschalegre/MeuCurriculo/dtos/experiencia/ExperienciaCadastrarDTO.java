package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ExperienciaCadastrarDTO(
        @NotBlank String nomeEmpresa,
        @NotBlank String cargo,
        @JsonFormat(pattern = "MM/yyyy/dd") String dataInicio,
        @JsonFormat(pattern = "MM/yyyy/dd") String dataTermino,
        @NotBlank String cidade,
        @Size(min = 255, max = 600) String resumoDeAtividades,
        @NotNull Long curriculoId
) {
}
