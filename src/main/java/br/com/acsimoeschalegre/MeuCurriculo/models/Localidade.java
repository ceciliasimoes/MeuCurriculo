package br.com.acsimoeschalegre.MeuCurriculo.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Localidade {
    private String cidade;
    private String estado;
    private String bairro;
}
