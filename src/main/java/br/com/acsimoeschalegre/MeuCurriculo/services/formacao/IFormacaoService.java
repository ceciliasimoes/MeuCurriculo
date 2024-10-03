package br.com.acsimoeschalegre.MeuCurriculo.services.formacao;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoAtulizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoDTO;

import java.util.List;

public interface IFormacaoService {
     FormacaoDTO addFormacao(FormacaoCadastrarDTO dto);

     FormacaoDTO atualizarFormacao(Long id,FormacaoAtulizarDTO dto);

     void deleteFormacao(Long id);

     List<FormacaoDTO> getAllFormacoes();

     FormacaoDTO findFormacaoById(Long id);

     FormacaoDTO findFormacaoByName(String nomeFormacao);
}
