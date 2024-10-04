package br.com.acsimoeschalegre.MeuCurriculo.controller;

import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.certificado.CertificadoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.curriculo.CurriculoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaAtualizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.experiencia.ExperienciaDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoAtulizarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoCadastrarDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.formacao.FormacaoDTO;
import br.com.acsimoeschalegre.MeuCurriculo.dtos.localidade.LocalidadeDTO;
import br.com.acsimoeschalegre.MeuCurriculo.models.*;
import br.com.acsimoeschalegre.MeuCurriculo.services.certificado.ICertificadoService;
import br.com.acsimoeschalegre.MeuCurriculo.services.curriculo.ICurriculoService;
import br.com.acsimoeschalegre.MeuCurriculo.services.experiencia.IExperienciaService;
import br.com.acsimoeschalegre.MeuCurriculo.services.formacao.IFormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculos")
public class Controller {

    @Autowired
    private ICurriculoService curriculoService;

    @Autowired
    private ICertificadoService certificadoService;

    @Autowired
    private IFormacaoService formacaoService;

    @Autowired
    private IExperienciaService experienciaService;

    @PostMapping("/{curriculoId}/experiencia")
    public ResponseEntity<ExperienciaDTO> createExperiencia(@PathVariable Long curriculoId, @RequestBody ExperienciaCadastrarDTO experienciaCadastrarDTO){
        var experiencia = this.experienciaService.addExperiencia(curriculoId,experienciaCadastrarDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(experiencia.id()).toUri();
        return ResponseEntity.created(uri).body(experiencia);
    }

    @PutMapping("/{curriculoId}/experiencia")
    public ResponseEntity<ExperienciaDTO> updateExperiencia(@PathVariable Long curriculoId, @RequestBody ExperienciaAtualizarDTO experienciaAtualizarDTO){
        var experiencia = this.experienciaService.updateExperiencia(curriculoId,experienciaAtualizarDTO);
        return ResponseEntity.ok(experiencia);
    }

    @DeleteMapping("/experiencia/{experienciaId}")
    public ResponseEntity deleteExperiencia(@PathVariable Long experienciaId){
         this.experienciaService.findExperienciaById(experienciaId);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/experiencia")
    public ResponseEntity<List<ExperienciaDTO>> getAllExperiencias(){
        var lista = this.experienciaService.getAllExperiencias();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/experiencia/{id}")
    public ResponseEntity<ExperienciaDTO> findExperienciaById(@PathVariable  Long id){
        var experiencia = this.experienciaService.findExperienciaById(id);
        return ResponseEntity.ok(experiencia);
    }

    @GetMapping("/experiencia/{nomeEmpresa}")
    public ResponseEntity<ExperienciaDTO> findExperienciaByNomeEmpresa(@PathVariable String nomeEmpresa){
        var experiencia = this.experienciaService.findExperienciaByNomeEmpresa(nomeEmpresa);
        return ResponseEntity.ok(experiencia);
    }



    @PostMapping("/{curriculoId}/formacao")
    public ResponseEntity<FormacaoDTO> addFormacao(@PathVariable Long curriculoId,@RequestBody FormacaoCadastrarDTO dto){
        var formacao = this.formacaoService.addFormacao(curriculoId,dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(formacao.id()).toUri();
        return ResponseEntity.created(uri).body(formacao);
    }

    @PutMapping("/formacao/{id}")
    public ResponseEntity<FormacaoDTO> atualizarFormacao(@PathVariable Long id, @RequestBody FormacaoAtulizarDTO dto){
        var formacao = this.formacaoService.atualizarFormacao(id,dto);
        return ResponseEntity.ok(formacao);
    }

    @DeleteMapping("/formacao/{id}")
    public ResponseEntity deleteFormacao(@PathVariable Long id){
        this.formacaoService.deleteFormacao(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/formacao")
    public ResponseEntity<List<FormacaoDTO>> getAllFormacoes(){
        var  lista = this.formacaoService.getAllFormacoes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/formacao/{id}")
    public ResponseEntity<FormacaoDTO> findFormacaoById(@PathVariable Long id){
        var formacao = this.formacaoService.findFormacaoById(id);
        return ResponseEntity.ok(formacao);
    }

    @GetMapping("/formacao/{nomeFormacao}")
    public ResponseEntity<FormacaoDTO> findFormacaoByName(@PathVariable String nomeFormacao){
        var formacao = this.formacaoService.findFormacaoByName(nomeFormacao);
        return ResponseEntity.ok(formacao);
    }



    @PostMapping("/{curriculoId}/certificado")
    public ResponseEntity<CertificadoDTO> addCertificado(@PathVariable Long curriculoId,@RequestBody CertificadoCadastrarDTO dto){
        var certificado = this.certificadoService.addCertificado(curriculoId,dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(certificado.id()).toUri();
        return ResponseEntity.created(uri).body(certificado);
    }

    @PutMapping("/certificado/{id}")
    public ResponseEntity<CertificadoDTO> updateCertificado(@PathVariable Long id, @RequestBody CertificadoAtualizarDTO dto){
        var certificado = this.certificadoService.updateCertificado(id,dto);
        return ResponseEntity.ok(certificado);
    }

    @DeleteMapping("/certificado/{id}")
    public ResponseEntity deleteCertificado(@PathVariable Long id){
       this.certificadoService.deleteCertificado(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/certificado")
    public ResponseEntity<List<CertificadoDTO>> getAllCertificados(){
        var lista = this.certificadoService.getAllCertificados();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/certificado/{id}")
    public ResponseEntity<CertificadoDTO> findCertificadoById(@PathVariable Long id){
        var certificado = this.certificadoService.findCertificadoById(id);
        return ResponseEntity.ok(certificado);
    }

    @GetMapping("/certificado/{quantidadeHoras}")
    public ResponseEntity<CertificadoDTO> findCertificadoByQuantidadeHoras(@PathVariable int quantidadeHoras){
        var certificado = this.certificadoService.findCertificadoByQuantidadeHoras(quantidadeHoras);
        return ResponseEntity.ok(certificado);
    }



    @PostMapping
    public ResponseEntity<CurriculoDTO> addCurriculo(@RequestBody CurriculoCadastrarDTO dto){
        var curriculo = this.curriculoService.addCurriculo(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curriculo.id()).toUri();
        return ResponseEntity.created(uri).body(curriculo);
    }

    @GetMapping
    public ResponseEntity<List<CurriculoDTO>> getCurriculoAll() {
        var curriculo = this.curriculoService.getAllCurriculos();
        return ResponseEntity.ok(curriculo);
    }

   @GetMapping("/{id}")
    public ResponseEntity<CurriculoDTO> findCurriculoById(@PathVariable Long id) {
        var curriculo = this.curriculoService.findById(id);
        return ResponseEntity.ok(curriculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurriculoDTO> updateCurriculo(@PathVariable Long id, @RequestBody CurriculoCadastrarDTO dto){
        var curriculo = this.curriculoService.updateCurriculo(id,dto);
        return ResponseEntity.ok(curriculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCurriculo(@PathVariable Long id) {
        this.curriculoService.deleteCurriculo(id);
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/{curriculoId}/formacao/{formacaoId}")
    public ResponseEntity<CurriculoDTO> deleteFormacao(@PathVariable Long curriculoId, @PathVariable Long formacaoId) {
       var curriculo = this.curriculoService.deleteFormacao(curriculoId,formacaoId);
       return ResponseEntity.ok(curriculo);
    }

    @DeleteMapping("/{curriculoId}/experiencia/{experienciaId}")
    public ResponseEntity<CurriculoDTO> deleteExperiencia(@PathVariable Long curriculoId,@PathVariable Long experienciaId) {
        var curriculo = this.curriculoService.deleteExperiencia(curriculoId,experienciaId);
        return ResponseEntity.ok(curriculo);
    }

    @DeleteMapping("/{curriculoId}/certificado/{certificadoId}")
    public ResponseEntity<CurriculoDTO> deleteCertificado(@PathVariable Long curriculoId, @PathVariable Long certificadoId) {
        var curriculo = this.curriculoService.deleteCertificado(curriculoId,certificadoId);
        return ResponseEntity.ok(curriculo);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<CurriculoDTO>> findByNome(@PathVariable String nome) {
        var curriculos = this.curriculoService.findByNome(nome);
        return ResponseEntity.ok(curriculos);
    }

    @GetMapping("/{competencia}")
    public ResponseEntity<List<CurriculoDTO>> findByCompetencia(@PathVariable String competencia) {
        var curriculos = this.curriculoService.findByCompetencia(competencia);
        return ResponseEntity.ok(curriculos);
    }

    @PatchMapping("/meio-contato/{curriculoId}")
    public ResponseEntity<CurriculoDTO> updateMeiosDeContato(@PathVariable Long curriculoId, @RequestBody List<String> novosContatos) {
        var curriculo = this.curriculoService.updateMeiosDeContato(curriculoId,novosContatos);
        return ResponseEntity.ok(curriculo);
    }

    @PatchMapping("/localidade/{curriculoId}")
    public ResponseEntity<CurriculoDTO> updateLocalidade(@PathVariable Long curriculoId, @RequestBody LocalidadeDTO localidadeDTO) {
        var curriculo = this.curriculoService.updateLocalidade(curriculoId,localidadeDTO);
        return ResponseEntity.ok(curriculo);
    }


}
