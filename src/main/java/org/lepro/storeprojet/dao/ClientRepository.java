package org.lepro.storeprojet.dao;

import org.lepro.storeprojet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
