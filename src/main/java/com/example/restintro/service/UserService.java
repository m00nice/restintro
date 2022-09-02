package com.example.restintro.service;

import com.example.restintro.model.User;
import com.example.restintro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class UserService implements UserInterface{

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public Set<User> findAll() {
        Set<User> set = new HashSet<>();
         repo.findAll().forEach(set::add);
         return set;
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }
}
