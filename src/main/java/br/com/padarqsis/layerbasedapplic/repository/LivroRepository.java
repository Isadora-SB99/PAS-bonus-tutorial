package br.com.padarqsis.layerbasedapplic.repository;

import br.com.padarqsis.layerbasedapplic.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
