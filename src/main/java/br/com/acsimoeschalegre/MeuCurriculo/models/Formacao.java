package br.com.acsimoeschalegre.MeuCurriculo.models;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastroDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.format.DateTimeFormatter;

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
    @JoinColumn(name = "curriculo_id", nullable = false)
    private Curriculo curriculo;

    private String instituicao;
    private String nomeFormacao;
    private String tipoFormacao;
    private String dataInicio ;
    private String dataTermino;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M-yyyy");

    public Formacao(FormacaoCadastroDTO dto){
        this.instituicao = dto.instituicao();
        this.nomeFormacao = dto.nomeFormacao();
        this.tipoFormacao = dto.tipoFormacao();
        this.dataInicio = dto.dataInicio().format(this.dateTimeFormatter);
        this.dataTermino = dto.dataTermino().format(this.dateTimeFormatter);
    }
}
