package br.com.acsimoeschalegre.MeuCurriculo.models;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "formacoes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;

    private String instituicao;
    private String nomeFormacao;
    private String tipoFormacao;
    private String dataInicio ;
    private String dataTermino;

    public Formacao(FormacaoCadastrarDTO dto, Curriculo curriculo){
        this.instituicao = dto.instituicao();
        this.nomeFormacao = dto.nomeFormacao();
        this.tipoFormacao = dto.tipoFormacao();
        this.dataInicio = dto.dataInicio();
        this.dataTermino = dto.dataTermino();
        this.curriculo = curriculo;
    }
}
