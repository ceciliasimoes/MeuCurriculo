package br.com.acsimoeschalegre.MeuCurriculo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "curriculos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

}
