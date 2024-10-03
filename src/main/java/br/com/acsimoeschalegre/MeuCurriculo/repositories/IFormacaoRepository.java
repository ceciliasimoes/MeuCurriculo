package br.com.acsimoeschalegre.MeuCurriculo.repositories;

import br.com.acsimoeschalegre.MeuCurriculo.models.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormacaoRepository extends JpaRepository<Formacao, Long> {
    Formacao findByNomeFormacaoContainsIgnoreCase(String nomeFormacao);
}
