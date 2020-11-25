package br.com.ricardoianni.domain.holerite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HoleriteRepository extends JpaRepository<Holerite, Integer> {

	public Holerite findByIdFuncAndMesAndAno(String idFunc, String mes, String ano);

}
