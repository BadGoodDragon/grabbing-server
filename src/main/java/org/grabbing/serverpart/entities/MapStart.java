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
@Table(name = "map_start")
public class MapStart {
    @Id @Column(name = "id") private Long id;

    @Column(name = "map_name") private String name;
}
