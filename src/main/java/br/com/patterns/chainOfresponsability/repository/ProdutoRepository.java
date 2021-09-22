package br.com.patterns.chainOfresponsability.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.patterns.chainOfresponsability.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
//	@Query("Select d From DiaPromocao d where d.diaSemana =:diaSemana ")
//	Optional<DiaPromocao> buscarPorDiaPromocional(@Param("diaSemana") DiaSemana diaSemana);

}
