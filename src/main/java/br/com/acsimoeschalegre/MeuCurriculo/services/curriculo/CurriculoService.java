package br.com.acsimoeschalegre.MeuCurriculo.services.curriculo;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.localidade.LocalidadeDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.*;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICertificadoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICurriculoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.IExperienciaRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.IFormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurriculoService implements ICurriculoService{

    @Autowired
    private ICurriculoRepository curriculoRepository;

    @Autowired
    private ICertificadoRepository certificadoRepository;

    @Autowired
    private IExperienciaRepository experienciaRepository;

    @Autowired
    private IFormacaoRepository formacaoRepository;

    @Override
    @Transactional
    public CurriculoDTO addCurriculo(CurriculoCadastrarDTO dto){
        Curriculo curriculo = new Curriculo(dto);
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
    public CurriculoDTO findById(Long id) {
        var curriculo = this.curriculoRepository.findById(id).orElseThrow(() -> new NullPointerException("Curriculo não encontrado!"));
        return new CurriculoDTO(curriculo);
    }

    @Override
    public List<CurriculoDTO> getAllCurriculos(){
        return this.curriculoRepository.findAll().stream().map(CurriculoDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CurriculoDTO updateCurriculo(Long id, CurriculoCadastrarDTO dto) {
        var curriculo = this.curriculoRepository.findById(id).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        if (dto.localidade() != null){
            curriculo.setLocalidade(new Localidade(dto.localidade()));
        }
        if (dto.objetivoProfissional() != null){
            curriculo.setObjetivoProfissional(dto.objetivoProfissional());
        }
        if (dto.meiosDeContato() != null){
            curriculo.setMeiosDeContato(dto.meiosDeContato());
        }
        if (dto.competencias() != null){
            curriculo.setCompetencias(dto.competencias());
        }
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
    @Transactional
    public void deleteCurriculo(Long id) {
        var curriculo = this.curriculoRepository.findById(id).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        var certificados = this.certificadoRepository.findByCurriculoId(id);
        var formacoes = this.formacaoRepository.findByCurriculoId(id);
        var experiencias = this.experienciaRepository.findByCurriculoId(id);

        this.certificadoRepository.deleteAllInBatch(certificados);
        this.formacaoRepository.deleteAllInBatch(formacoes);
        this.experienciaRepository.deleteAllInBatch(experiencias);

        this.curriculoRepository.delete(curriculo);
    }

    @Override
    @Transactional
    public CurriculoDTO addFormacao(Long curriculoId, FormacaoCadastrarDTO formacaoDTO) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.getFormacaoAcademica().add(new Formacao(formacaoDTO,curriculo));
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
    @Transactional
    public CurriculoDTO deleteFormacao(Long curriculoId, Long formacaoId) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        var formacao = this.formacaoRepository.findById(formacaoId).orElseThrow(()-> new NullPointerException("Formação não encontrado!"));
        curriculo.getFormacaoAcademica().remove(formacao);

        if (curriculo.getFormacaoAcademica().contains(formacao)) {
            curriculo.getFormacaoAcademica().remove(formacao);
            this.curriculoRepository.save(curriculo);
        } else {
            throw new IllegalArgumentException("A formação não está associada a este currículo!");
        }

        return new CurriculoDTO(curriculo);
    }

    @Override
    @Transactional
    public CurriculoDTO addExperiencia(Long curriculoId, ExperienciaCadastrarDTO experienciaDTO) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.getExperienciaProfissional().add(new Experiencia(experienciaDTO, curriculo));
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
    @Transactional
    public CurriculoDTO deleteExperiencia(Long curriculoId, Long experienciaId) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        var experiencia = this.experienciaRepository.findById(experienciaId).orElseThrow(()-> new NullPointerException("Experiência não encontrado!"));

        if (curriculo.getExperienciaProfissional().contains(experiencia)) {
            curriculo.getExperienciaProfissional().remove(experiencia);
            this.curriculoRepository.save(curriculo);
        } else {
            throw new IllegalArgumentException("A experiência não está associada a este currículo!");
        }

        return new CurriculoDTO(curriculo);
    }

    @Override
    @Transactional
    public CurriculoDTO addCertificado(Long curriculoId, CertificadoCadastrarDTO certificadoDTO) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.getCertificados().add(new Certificado(certificadoDTO, curriculo));
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
    @Transactional
    public CurriculoDTO deleteCertificado(Long curriculoId, Long certificadoId) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        var certificado = this.certificadoRepository.findById(certificadoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        if (curriculo.getCertificados().contains(certificado)) {
            curriculo.getCertificados().remove(certificado);
            this.curriculoRepository.save(curriculo);
        } else {
            throw new IllegalArgumentException("O certificado não está associado a este currículo!");
        }
        return new CurriculoDTO(curriculo);
    }

    @Override
    public List<CurriculoDTO> findByNome(String nome) {
        List<Curriculo> curriculos = this.curriculoRepository.findByNomeContainsIgnoreCase(nome);
        return curriculos.stream().map(CurriculoDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CurriculoDTO> findByCompetencia(String competencia) {
        List<Curriculo> curriculos = this.curriculoRepository.findByCompetencia(competencia);
        return curriculos.stream().map(CurriculoDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CurriculoDTO updateMeiosDeContato(Long curriculoId, List<String> novosContatos) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.setMeiosDeContato(novosContatos);
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
    public CurriculoDTO updateLocalidade(Long curriculoId, LocalidadeDTO localidadeDTO) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.setLocalidade(new Localidade(localidadeDTO));
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }
}
