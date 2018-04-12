package org.lepro.storeprojet.dao;

import org.lepro.storeprojet.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	@Query("select p from Categorie p where p.designation like :x or p.nomCategorie like :x")
	public Page<Categorie> chercher(@Param("x") String mc, Pageable pageable);
}
