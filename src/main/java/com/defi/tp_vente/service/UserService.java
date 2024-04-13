package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
