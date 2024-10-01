package br.com.acsimoeschalegre.MeuCurriculo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "experiencias")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeEmpresa;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M-yyyy");
    private String cidade;

    @Size(min = 255, max = 600)
    private String resumoDeAtividades;


}
