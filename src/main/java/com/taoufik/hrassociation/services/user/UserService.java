package com.taoufik.hrassociation.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taoufik.hrassociation.models.User;
import com.taoufik.hrassociation.repositories.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User createUser(User user) {
        // Vérifier si l'email existe déjà
        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserByEmail.isPresent()) {
            throw new ValidationException("Cet email est déjà utilisé !");
        }

        // Vérifier si le téléphone existe déjà
        Optional<User> existingUserByPhone = userRepository.findByPhone(user.getPhone());
        if (existingUserByPhone.isPresent()) {
            throw new ValidationException("Ce numéro de téléphone est déjà utilisé !");
        }

        // Hasher le mot de passe 
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Sauvegarde de l'utilisateur
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

}
