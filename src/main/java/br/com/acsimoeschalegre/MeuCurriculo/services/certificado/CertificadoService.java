package br.com.acsimoeschalegre.MeuCurriculo.services.certificado;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Certificado;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICertificadoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertificadoService implements ICertificadoService{

    @Autowired
    public ICertificadoRepository certificadoRepository;

    @Autowired
    public ICurriculoRepository curriculoRepository;

    @Override
    @Transactional
    public CertificadoDTO addCertificado(Long curriculoId, CertificadoCadastrarDTO dto){
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Currículo não encontrado!"));
        Certificado certificado = new Certificado(dto, curriculo);
        this.certificadoRepository.save(certificado);
        return new CertificadoDTO(certificado);
    }

    @Override
    @Transactional
    public CertificadoDTO updateCertificado(Long id,CertificadoAtualizarDTO dto){
        var certificado = this.certificadoRepository.findById(id).orElseThrow(()-> new NullPointerException("Certificado não encontrada!"));
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
        return new CertificadoDTO(certificado);
    }

    @Override
    @Transactional
    public void deleteCertificado(Long id){
        var certificado = this.certificadoRepository.findById(id).orElseThrow(()-> new NullPointerException("Certificado não encontrada!"));
        this.certificadoRepository.delete(certificado);
    }

    @Override
    public List<CertificadoDTO> getAllCertificados(){
        List<Certificado> lista = this.certificadoRepository.findAll();
        return lista.stream().map(CertificadoDTO::new).collect(Collectors.toList());
    }

    @Override
    public CertificadoDTO findCertificadoById(Long id){
        var certificado = this.certificadoRepository.findById(id).orElseThrow(()-> new NullPointerException("Certificado não encontrada!"));
        return new CertificadoDTO(certificado);
    }

    @Override
    public CertificadoDTO findCertificadoByQuantidadeHoras(int quantidadeHoras){
        Certificado certificado = this.certificadoRepository.findByQuantidadeHoras(quantidadeHoras);
        return new CertificadoDTO(certificado);
    }
}
