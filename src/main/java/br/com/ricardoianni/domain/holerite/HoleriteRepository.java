package br.com.ricardoianni.domain.holerite;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.domain.employee.Colaborador;

public interface HoleriteRepository extends JpaRepository<Holerite, Integer> {

	public Holerite findByColaboradorHoleriteAndMesAndAno(Colaborador colaboradorHolerite, String mes, String ano);

}
