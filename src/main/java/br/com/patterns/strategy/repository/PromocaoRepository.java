package br.com.patterns.strategy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.patterns.strategy.model.DiaPromocao;
import br.com.patterns.strategy.model.DiaSemana;

@Repository
public interface PromocaoRepository extends JpaRepository<DiaPromocao, Long>{
	
	@Query("Select d From DiaPromocao d where d.diaSemana =:diaSemana ")
	Optional<DiaPromocao> buscarPorDiaPromocional(@Param("diaSemana") DiaSemana diaSemana);

}
