package com.minhld.planb.data.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Document
@Data
public class User implements UserDetails {
    private @MongoId ObjectId id;
    private String username;
    private String password;
    private Set<GrantedAuthority> userRoles;

    public User(String username, String password, Set<GrantedAuthority> userRoles) {
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return this.userRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
