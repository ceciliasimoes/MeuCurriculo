package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;


public record ExperienciaAtualizarDTO(
        @JsonFormat(pattern = "MM/yyyy/dd") String dataInicio,
        @JsonFormat(pattern = "MM/yyyy/dd") String dataTermino,
        String cidade,
        @Size(min = 255, max = 600) String resumoDeAtividades
) {
}
