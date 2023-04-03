package com.minhld.planb.data.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
public class UserRole implements GrantedAuthority {
    private Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }
}
