package com.sukhyna.service;

import com.sukhyna.dao.RoleRepository;
import com.sukhyna.dao.UserRepository;
import com.sukhyna.model.Role;
import com.sukhyna.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(getDefaultRole());
        return userRepository.save(user);
    }

    @Override
    public Optional<List<User>> getAll() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.getByEmail(email)
                .map(u -> org.springframework.security.core.userdetails.User.builder()
                        .username(u.getEmail())
                        .password(u.getPassword())
                        .authorities(toAuthorities(u.getRoles()))
                        .build()
                ).orElseGet(() -> org.springframework.security.core.userdetails.User.builder().build());
    }

    private List<GrantedAuthority> toAuthorities(List<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(toList());
    }

    private List<Role> getDefaultRole(){
        List<Role> defaultRole = new ArrayList<>();
        defaultRole.add(roleRepository.getByName("user").get());
        return defaultRole;
    }
}