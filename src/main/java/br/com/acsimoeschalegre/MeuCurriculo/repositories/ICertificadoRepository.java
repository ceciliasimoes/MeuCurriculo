package br.com.acsimoeschalegre.MeuCurriculo.repositories;

import br.com.acsimoeschalegre.MeuCurriculo.models.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICertificadoRepository extends JpaRepository<Certificado, Long> {
    Certificado findByQuantidadeHoras(int quantidadeHoras);

    List<Certificado> findByCurriculoId(Long id);
}
