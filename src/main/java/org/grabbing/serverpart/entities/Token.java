package org.grabbing.serverpart.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "token")
public class Token {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "token")
    String token;
    @Column(name = "account_id")
    Long accountId;
}
