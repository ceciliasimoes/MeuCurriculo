package br.com.acsimoeschalegre.MeuCurriculo.services.experiencia;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Experiencia;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface IExperienciaService {
     void addExperiencia(ExperienciaCadastrarDTO dto);

     void atualizarExperiencia(ExperienciaAtualizarDTO dto);

     void deleteExperiencia(Long id);

     List<ExperienciaDTO> getAlExperienciasl();

     ExperienciaDTO findExperienciaById(Long id);

     ExperienciaDTO findExperienciaByNomeEmpresa(String nomeEmpresa);

}
