package br.com.acsimoeschalegre.MeuCurriculo.services.experiencia;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaDTO;

import java.util.List;


public interface IExperienciaService {
     ExperienciaDTO addExperiencia(ExperienciaCadastrarDTO dto);

     ExperienciaDTO updateExperiencia(Long id,ExperienciaAtualizarDTO dto);

     void deleteExperiencia(Long id);

     List<ExperienciaDTO> getAllExperiencias();

     ExperienciaDTO findExperienciaById(Long id);

     ExperienciaDTO findExperienciaByNomeEmpresa(String nomeEmpresa);

}
