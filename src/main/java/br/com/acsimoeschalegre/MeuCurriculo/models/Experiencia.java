package br.com.acsimoeschalegre.MeuCurriculo.models;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "experiencias")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEmpresa;
    private String cargo;
    private String dataInicio;
    private String dataTermino;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M-yyyy");
    private String cidade;

    @Size(min = 255, max = 600)
    private String resumoDeAtividades;

    public Experiencia(ExperienciaCadastrarDTO dto){
        this.nomeEmpresa = dto.nomeEmpresa();
        this.cargo = dto.cargo();
        this.dataInicio = dto.dataInicio().format(this.dateTimeFormatter);
        this.dataTermino = dto.dataTermino().format(this.dateTimeFormatter);
        this.cidade = dto.cidade();
        this.resumoDeAtividades = dto.resumoDeAtividades();
    }

}
