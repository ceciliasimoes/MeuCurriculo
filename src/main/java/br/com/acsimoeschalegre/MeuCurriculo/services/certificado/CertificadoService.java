package br.com.acsimoeschalegre.MeuCurriculo.services.certificado;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Certificado;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CertificadoService implements ICertificadoService{

    @Autowired
    public ICertificadoRepository certificadoRepository;

    public void addCertificado(CertificadoCadastrarDTO dto){
        Certificado certificado = new Certificado(dto);
        this.certificadoRepository.save(certificado);
    }

    public void atualizarCertificado(CertificadoAtualizarDTO dto){
        var certificado = this.certificadoRepository.findById(dto.id()).orElseThrow(()-> new NullPointerException("Certificado não encontrada!"));
        if( dto.nomeCertificado() != null){
            certificado.setNomeCertificado(dto.nomeCertificado());
        }
        if(dto.instituicao() != null){
            certificado.setInstituicao(dto.instituicao());
        }
        if(dto.quantidadeHoras() != null){
            certificado.setQuantidadeHoras(dto.quantidadeHoras());
        }
        this.certificadoRepository.save(certificado);
    }

    public void deleteCertificado(Long id){
        this.certificadoRepository.deleteById(id);
    }

    public List<CertificadoDTO> getAllCertificados(){
        List<Certificado> lista = this.certificadoRepository.findAll();
        return lista.stream().map(CertificadoDTO::new).collect(Collectors.toList());
    }

    public CertificadoDTO findCertificadoById(Long id){
        Optional<Certificado> certificado = this.certificadoRepository.findById(id);
        return new CertificadoDTO(certificado.get());
    }

    public CertificadoDTO findCertificadoByQuantidadeHoras(int quantidadeHoras){
        Certificado certificado = this.certificadoRepository.findByQuantidadeHoras(quantidadeHoras);
        return new CertificadoDTO(certificado);
    }
}
