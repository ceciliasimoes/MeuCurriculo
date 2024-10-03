package br.com.acsimoeschalegre.MeuCurriculo.models;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoCadastrarDTO;
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

    @OneToMany(mappedBy = "curriculo")
    private List<Formacao> formacaoAcademica;

    @OneToMany(mappedBy = "curriculo")
    private List<Experiencia> experienciaProfissional;

    private List<String> competencias;

    @OneToMany(mappedBy = "curriculo")
    private List<Certificado> certificados;

    public Curriculo(CurriculoCadastrarDTO dto){
        this.nome = dto.nome();
        this.localidade = new Localidade(dto.localidade());
        this.objetivoProfissional = dto.objetivoProfissional();
        this.meiosDeContato = dto.meiosDeContato();
        this.competencias = dto.competencias();

    }

}
