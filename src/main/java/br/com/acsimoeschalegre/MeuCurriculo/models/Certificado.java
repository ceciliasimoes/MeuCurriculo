package br.com.acsimoeschalegre.MeuCurriculo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "certificados")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeCertificado;
    private String instituicao;
    private int quantidadeHoras;

    @Size(min = 255, max = 600)
    private String resumoDeAtividades;
}
