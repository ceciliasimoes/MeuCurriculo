package br.com.acsimoeschalegre.MeuCurriculo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "formacoes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "curriculo_id", nullable = false)
    private Curriculo curriculo;

    private String instituicao;
    private String nomeFormacao;
    private String tipoFormacao;
    private String dataInicio ;
    private String  dataTermino;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M-yyyy");

//    public Formacao(LocalDate dataInicio, LocalDate dataTermino){
//        this.dataInicio = dataInicio.format(this.dateTimeFormatter);
//        this.dataTermino = dataTermino.format(this.dateTimeFormatter);
//    }
}
