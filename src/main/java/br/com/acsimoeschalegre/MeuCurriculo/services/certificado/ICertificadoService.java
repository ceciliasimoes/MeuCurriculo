package br.com.acsimoeschalegre.MeuCurriculo.services.certificado;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoDTO;

import java.util.List;

public interface ICertificadoService {

     void addCertificado(CertificadoCadastrarDTO dto);

     void atualizarCertificado(CertificadoAtualizarDTO dto);

     void deleteCertificado(Long id);

     List<CertificadoDTO> getAllCertificados();

     CertificadoDTO findCertificadoById(Long id);

     CertificadoDTO findCertificadoByQuantidadeHoras(int quantidadeHoras);
}


