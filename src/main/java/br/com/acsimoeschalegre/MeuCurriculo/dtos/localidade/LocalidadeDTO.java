package br.com.acsimoeschalegre.MeuCurriculo.dtos.localidade;

import jakarta.validation.constraints.NotBlank;

public record LocalidadeDTO(
     @NotBlank String cidade,
     @NotBlank String estado,
     @NotBlank String bairro
) {

}
