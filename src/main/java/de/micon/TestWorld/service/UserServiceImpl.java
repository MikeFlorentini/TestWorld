/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.service;

import de.micon.TestWorld.entity.User;
import de.micon.TestWorld.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mmende
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
}
