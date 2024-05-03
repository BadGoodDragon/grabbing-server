package org.grabbing.serverpart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "account_role")
public class Role /*implements GrantedAuthority*/ {
    @Id @Column(name = "id") private Long id;
    @Column(name = "role_name") private String roleName;

    /*@Override
    public String getAuthority() {
        return roleName;
    }*/
}
