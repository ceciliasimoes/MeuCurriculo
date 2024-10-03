package br.com.acsimoeschalegre.MeuCurriculo.services.curriculo;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;

import java.util.List;

public interface ICurriculoService {
    CurriculoDTO addCurriculo(CurriculoCadastrarDTO dto);

    CurriculoDTO findById(Long id);

    CurriculoDTO updateCurriculo(Long id, CurriculoCadastrarDTO dto);

    void deleteCurriculo(Long id);

    List<CurriculoDTO> findAllCurriculos();

    // Métodos específicos
    CurriculoDTO addFormacao(Long curriculoId, FormacaoCadastrarDTO formacaoDTO);

    CurriculoDTO deleteFormacao(Long curriculoId, Long formacaoId);

    CurriculoDTO addExperiencia(Long curriculoId, ExperienciaCadastrarDTO experienciaDTO);

    CurriculoDTO deleteExperiencia(Long curriculoId, Long experienciaId);

    CurriculoDTO addCertificado(Long curriculoId, CertificadoCadastrarDTO certificadoDTO);

    CurriculoDTO deleteCertificado(Long curriculoId, Long certificadoId);

    // Métodos de busca
    List<CurriculoDTO> findByNome(String nome);

    List<CurriculoDTO> findByCompetencia(String competencia);

    // Atualização de dados específicos
    CurriculoDTO updateMeiosDeContato(Long curriculoId, List<String> novosContatos);

}
