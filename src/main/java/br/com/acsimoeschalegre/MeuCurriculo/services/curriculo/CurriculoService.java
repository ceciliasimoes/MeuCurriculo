package br.com.acsimoeschalegre.MeuCurriculo.services.curriculo;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.Curriculo;
import br.com.acsimoeschalegre.MeuCurriculo.models.Experiencia;
import br.com.acsimoeschalegre.MeuCurriculo.models.Formacao;
import br.com.acsimoeschalegre.MeuCurriculo.models.Localidade;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICertificadoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.ICurriculoRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.IExperienciaRepository;
import br.com.acsimoeschalegre.MeuCurriculo.repositories.IFormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteCurriculo(Long id) {
        var curriculo = this.curriculoRepository.findById(id).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        this.curriculoRepository.delete(curriculo);
    }

    @Override
    public List<CurriculoDTO> findAllCurriculos() {
        return this.curriculoRepository.findAll().stream().map(CurriculoDTO::new).collect(Collectors.toList());
    }

    @Override
    public CurriculoDTO addFormacao(Long curriculoId, FormacaoCadastrarDTO formacaoDTO) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.getFormacaoAcademica().add(new Formacao(formacaoDTO,curriculo));
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
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
    public CurriculoDTO addExperiencia(Long curriculoId, ExperienciaCadastrarDTO experienciaDTO) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.getExperienciaProfissional().add(new Experiencia(experienciaDTO, curriculo));
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }

    @Override
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
    public CurriculoDTO addCertificado(Long curriculoId, CertificadoCadastrarDTO certificadoDTO) {
        return null;
    }

    @Override
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
        List<Curriculo> curriculos = this.curriculoRepository.findByNameContainsIgnoreCase(nome);
        return curriculos.stream().map(CurriculoDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CurriculoDTO> findByCompetencia(String competencia) {
        List<Curriculo> curriculos = this.curriculoRepository.findByCompetencia(competencia);
        return List.of();
    }

    @Override
    public CurriculoDTO updateMeiosDeContato(Long curriculoId, List<String> novosContatos) {
        var curriculo = this.curriculoRepository.findById(curriculoId).orElseThrow(()-> new NullPointerException("Curriculo não encontrado!"));
        curriculo.setMeiosDeContato(novosContatos);
        this.curriculoRepository.save(curriculo);
        return new CurriculoDTO(curriculo);
    }
}
