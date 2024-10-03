package br.com.acsimoeschalegre.MeuCurriculo.services.formacao;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoAtulizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Formacao;
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

    public void addFormacao(FormacaoCadastrarDTO dto){
        Formacao formacao = new Formacao(dto);
        this.formacaoRepository.save(formacao);
    }

    public void atualizarFormacao(FormacaoAtulizarDTO dto){
        var formacao = this.formacaoRepository.findById(dto.id()).orElseThrow(()-> new NullPointerException("Formação não encontrada!"));
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
    }

    public void deleteFormacao(Long id){
        this.formacaoRepository.deleteById(id);
    }

    public List<FormacaoDTO> getAllFormacoes(){
        List<Formacao> lista = this.formacaoRepository.findAll();
        return lista.stream().map(FormacaoDTO::new).collect(Collectors.toList());
    }

    public FormacaoDTO findFormacaoById(Long id){
        Optional<Formacao> formacao = this.formacaoRepository.findById(id);
        return new FormacaoDTO(formacao.get());
    }

    public FormacaoDTO findFormacaoByName(String nomeFormacao){
        Formacao formacao = this.formacaoRepository.findByNomeContainsIgnoreCase(nomeFormacao);
        return new FormacaoDTO(formacao);
    }
}
