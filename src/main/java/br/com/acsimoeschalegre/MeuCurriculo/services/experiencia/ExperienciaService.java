package br.com.acsimoeschalegre.MeuCurriculo.services.experiencia;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Curriculo;
import br.com.acsimoeschalegre.MeuCurriculo.models.Experiencia;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICurriculoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    public IExperienciaRepository experienciaRepository;

    @Autowired
    public ICurriculoRepository curriculoRepository;

    @Override
    @Transactional
    public ExperienciaDTO addExperiencia(Long curriculoId,ExperienciaCadastrarDTO dto){
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Currículo não encontrado!"));
        Experiencia experiencia = new Experiencia(dto, curriculo);
        this.experienciaRepository.save(experiencia);
        return  new ExperienciaDTO(experiencia);
    }

    @Override
    @Transactional
    public ExperienciaDTO updateExperiencia(Long id,ExperienciaAtualizarDTO dto){
        var experiencia = this.experienciaRepository.findById(id).orElseThrow(()-> new NullPointerException("Experiência não encontrada!"));
        if( dto.cidade() != null){
            experiencia.setCidade(dto.cidade());
        }
        if(dto.dataInicio() != null){
            experiencia.setDataInicio(dto.dataInicio());
        }
        if(dto.dataTermino() != null){
            experiencia.setDataTermino(dto.dataTermino());
        }
        this.experienciaRepository.save(experiencia);
        return new ExperienciaDTO(experiencia);
    }


    @Override
    @Transactional
    public void deleteExperiencia(Long id){
        var experiencia = this.experienciaRepository.findById(id).orElseThrow(()-> new NullPointerException("Experiência não encontrada!"));
        this.experienciaRepository.delete(experiencia);
    }
    @Override
    public List<ExperienciaDTO> getAllExperiencias(){
        List<Experiencia> lista = this.experienciaRepository.findAll();
        return lista.stream().map(ExperienciaDTO::new).collect(Collectors.toList());
    }
    @Override
    public ExperienciaDTO findExperienciaById(Long id){
       var experiencia = this.experienciaRepository.findById(id).orElseThrow(()-> new NullPointerException("Experiência não encontrada!"));
        return new ExperienciaDTO(experiencia);
    }
    @Override
    public ExperienciaDTO findExperienciaByNomeEmpresa(String nomeEmpresa){
        Experiencia experiencia = this.experienciaRepository.findByNomeEmpresaContainsIgnoreCase(nomeEmpresa);
        return new ExperienciaDTO(experiencia);
    }

}
