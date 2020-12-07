package br.com.ricardoianni.domain.masteruser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterUserRepository extends JpaRepository<MasterUser, Integer> {
	
	public MasterUser findByUsername(String username);
	
}
