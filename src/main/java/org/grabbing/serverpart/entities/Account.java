package org.grabbing.serverpart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "account")
public class Account /*implements UserDetails*/ {
    @Id @Column(name = "id") private Long id;

    @Column(name = "username") private String username;
    @Column(name = "password_hashed") private String password;

    @Column(name = "face_id") private Long faceId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "relationship_account_and_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> authorities;

    @Column(name = "enabled") private Boolean enabled;

    /*@Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }*/
}
