package br.com.acsimoeschalegre.MeuCurriculo.models;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "certificados")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;

    private String nomeCertificado;
    private String instituicao;
    private int quantidadeHoras;
    @Size(min = 255, max = 600)
    private String resumoDeAtividades;

    public Certificado(CertificadoCadastrarDTO dto, Curriculo curriculo){
        this.nomeCertificado = dto.nomeCertificado();
        this.instituicao = dto.instituicao();
        this.quantidadeHoras = dto.quantidadeHoras();
        this.resumoDeAtividades = dto.resumoDeAtividades();
        this.curriculo = curriculo;
    }
}
