package org.lepro.storeprojet.dao;

import org.lepro.storeprojet.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
