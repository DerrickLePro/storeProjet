package org.lepro.storeprojet.dao;

import org.lepro.storeprojet.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("select p from Client p where p.nomClient like :x ")
	public Page<Client> chercher(@Param("x") String mc, Pageable pageable);

}
