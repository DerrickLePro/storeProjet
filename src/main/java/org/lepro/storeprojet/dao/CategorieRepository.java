package org.lepro.storeprojet.dao;

import org.lepro.storeprojet.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
