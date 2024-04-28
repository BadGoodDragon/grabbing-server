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
@Table(name = "host")
public class Host {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "last_take")
    Long lastTake;
}
