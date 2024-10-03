package br.com.acsimoeschalegre.MeuCurriculo.services.formacao;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoAtulizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Curriculo;
import br.com.acsimoeschalegre.MeuCurriculo.models.Formacao;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICurriculoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.IFormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormacaoService  implements IFormacaoService{
    @Autowired
    public IFormacaoRepository formacaoRepository;

    @Autowired
    public ICurriculoRepository curriculoRepository;

    @Override
    public FormacaoDTO addFormacao(FormacaoCadastrarDTO dto){
        var curriculo = this.curriculoRepository.findById(dto.curriculoId()).orElseThrow(()-> new NullPointerException("Currículo não encontrado!"));
        Formacao formacao = new Formacao(dto, curriculo);
        this.formacaoRepository.save(formacao);
        return new FormacaoDTO(formacao);
    }

    @Override
    public FormacaoDTO atualizarFormacao(Long id,FormacaoAtulizarDTO dto){
        var formacao = this.formacaoRepository.findById(id).orElseThrow(()-> new NullPointerException("Formação não encontrada!"));
        if (dto.tipoFormacao() != null){
            formacao.setTipoFormacao(dto.tipoFormacao());
        }
        if(dto.dataInicio() != null){
            formacao.setDataInicio(dto.dataInicio());
        }
        if(dto.dataTermino() != null){
            formacao.setDataTermino(dto.dataTermino());
        }
        this.formacaoRepository.save(formacao);
        return new FormacaoDTO(formacao);
    }

    @Override
    public void deleteFormacao(Long id){
        this.formacaoRepository.deleteById(id);
    }

    public List<FormacaoDTO> getAllFormacoes(){
        List<Formacao> lista = this.formacaoRepository.findAll();
        return lista.stream().map(FormacaoDTO::new).collect(Collectors.toList());
    }

    @Override
    public FormacaoDTO findFormacaoById(Long id){
        var formacao = this.formacaoRepository.findById(id).orElseThrow(()-> new NullPointerException("Formação não encontrada!"));
        return new FormacaoDTO(formacao);
    }

    @Override
    public FormacaoDTO findFormacaoByName(String nomeFormacao){
        Formacao formacao = this.formacaoRepository.findByNomeFormacaoContainsIgnoreCase(nomeFormacao);
        return new FormacaoDTO(formacao);
    }
}
