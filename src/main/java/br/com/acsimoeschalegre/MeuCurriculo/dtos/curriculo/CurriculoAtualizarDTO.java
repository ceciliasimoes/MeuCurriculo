package br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.localidade.LocalidadeDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CurriculoAtualizarDTO(
        @Valid LocalidadeDTO localidade,
        @Size(min = 255, max = 600) String objetivoProfissional,
        List<String> meiosDeContato,
        List<String> competencias
) {
}
