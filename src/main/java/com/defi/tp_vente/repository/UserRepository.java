package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}