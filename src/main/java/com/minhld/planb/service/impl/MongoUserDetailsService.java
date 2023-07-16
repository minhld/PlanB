package com.minhld.planb.service.impl;

import com.minhld.planb.data.object.User;
import com.minhld.planb.data.repository.UserRepository;
import com.minhld.planb.exception.LoginException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MongoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(userName);
        if (user == null) {
            throw new LoginException(userName);
        }
        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    public UserDetails saveUser(String username, String password) {
        return userRepository.save(new User(username, password, null));
    }
}
