package br.com.ricardoianni.domain.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

	public Competencia findByIdCompetencia(Integer idCompetencia);
	
	public List<Competencia> findByColaboradorCompetenciaAndMesAndAno(Colaborador colaboradorCompetencia, String mes, String ano);

	public List<Competencia> findByColaboradorCompetenciaOrderByAnoDescMesDesc(Colaborador colaboradorCompetencia);
	
}
