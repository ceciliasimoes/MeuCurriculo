package br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Curriculo;

import java.util.Collections;
import java.util.List;

public record CurriculoDTO(
        Long id,
        String nome,
        String localidade,
        String objetivoProfissional,
        List<String> meiosDeContato,
        List<String> competencias,
        List<FormacaoDTO> formacoes,
        List<ExperienciaDTO> experiencias,
        List<CertificadoDTO> certificadoDTOS
) {
    public CurriculoDTO(Curriculo curriculo) {
        this(curriculo.getId(),
                curriculo.getNome(),
                curriculo.getLocalidade() != null ? curriculo.getLocalidade().toString() : null,  // Verificação de null para Localidade
                curriculo.getObjetivoProfissional(),
                curriculo.getMeiosDeContato(),
                curriculo.getCompetencias(),
                curriculo.getFormacaoAcademica() != null ? curriculo.getFormacaoAcademica().stream().map(FormacaoDTO::new).toList() : Collections.emptyList(),
                curriculo.getExperienciaProfissional() != null ? curriculo.getExperienciaProfissional().stream().map(ExperienciaDTO::new).toList() : Collections.emptyList(),
                curriculo.getCertificados() != null ? curriculo.getCertificados().stream().map(CertificadoDTO::new).toList() : Collections.emptyList());
    }

}