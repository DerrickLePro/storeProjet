package org.lepro.storeprojet.dao;

import java.util.List;

import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findAllBycategorie(Categorie c);

	@Query("select p from Produit p where p.designation like :x or p.description like :x")
	List<Produit> findAllByMotCle(@Param("x") String mcle);

	@Query("select p from Produit p where p.selected = true")
	List<Produit> listProduitSelected();

	@Query("select p from Produit p where p.designation like :x or p.description like :x")
	public Page<Produit> chercher(@Param("x") String mc, Pageable pageable);

	@Query("select p from Produit p where p.idProduit = :x ")
	public Produit findByIdC(@Param("x") Long idCl);
}
