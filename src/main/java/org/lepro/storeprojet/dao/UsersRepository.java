package org.lepro.storeprojet.dao;

import org.lepro.storeprojet.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
