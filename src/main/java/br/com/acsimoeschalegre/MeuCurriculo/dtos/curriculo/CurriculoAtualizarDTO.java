package br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CurriculoAtualizarDTO(
        @NotNull Long id,
        String localidade,
        @Size(min = 255, max = 600) String objetivoProfissional,
        List<String> meiosDeContato,
        List<String> competencias
) {
}
