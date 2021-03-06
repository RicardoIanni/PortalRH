package br.com.ricardoianni.domain.holerite;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.employee.Colaborador;

public interface HoleriteRepository extends JpaRepository<Holerite, Integer> {

	public Holerite findByColaboradorHoleriteAndEmpresaHoleriteAndMesAndAnoAndTipoRecibo(Colaborador colaboradorHolerite,
																						 Empresa empresaHolerite,
																						 String mes, 
																						 String ano,
																						 TipoRecibo tipoRecibo);
	
	public Holerite findByIdHolerite(Integer idHolerite);

}
