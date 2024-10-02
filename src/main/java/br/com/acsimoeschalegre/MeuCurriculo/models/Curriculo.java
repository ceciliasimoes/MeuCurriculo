package br.com.acsimoeschalegre.MeuCurriculo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "curriculos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Localidade localidade;

    @Size(min = 255, max = 600)
    private String objetivoProfissional;

    private List<String> meiosDeContato;

    @OneToMany(mappedBy = "curriculo_id")
    private List<Formacao> formacaoAcademica;

    @OneToMany(mappedBy = "curriculo_id")
    private List<Experiencia> experienciaProfissional;

    private List<String> competencias;

    @OneToMany(mappedBy = "curriculo_id")
    private List<Certificado> certificados;

    public Curriculo(){

    }

}
