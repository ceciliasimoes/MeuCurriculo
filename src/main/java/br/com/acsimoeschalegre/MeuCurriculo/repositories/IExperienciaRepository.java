package br.com.acsimoeschalegre.MeuCurriculo.repositories;

import br.com.acsimoeschalegre.MeuCurriculo.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    Experiencia findByNomeEmpresaContainsIgnoreCase(String nomeEmpresa);

    List<Experiencia> findByCurriculoId(Long id);
}
