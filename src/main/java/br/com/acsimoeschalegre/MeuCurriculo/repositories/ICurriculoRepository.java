package br.com.acsimoeschalegre.MeuCurriculo.repositories;

import br.com.acsimoeschalegre.MeuCurriculo.models.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICurriculoRepository extends JpaRepository<Curriculo, Long> {
    List<Curriculo> findByNameContainsIgnoreCase(String nome);

    @Query("SELECT c FROM Curriculo c JOIN c.competencias comp WHERE UPPER(comp.nome) = UPPER(:competencia)")
    List<Curriculo> findByCompetencia(@Param("competencia") String competencia);
}
