package br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia;

import br.com.acsimoeschalegre.MeuCurriculo.models.Experiencia;

import java.time.LocalDate;

public record ExperienciaDTO (
        Long id,
        String nomeEmpresa,
        String cargo,
        LocalDate  dataInicio,
        LocalDate dataTermino,
        String cidade,
        String resumoDeAtividades
) {
    public ExperienciaDTO(Experiencia experiencia) {
        this(experiencia.getId(), experiencia.getNomeEmpresa(), experiencia.getCargo(), experiencia.getDataInicio(),
                experiencia.getDataTermino(), experiencia.getCidade(), experiencia.getResumoDeAtividades());
    }
}
