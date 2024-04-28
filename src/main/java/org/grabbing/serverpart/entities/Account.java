package org.grabbing.serverpart.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "password")
    String password;
    @Column(name = "face_id")
    Long faceId;
}
