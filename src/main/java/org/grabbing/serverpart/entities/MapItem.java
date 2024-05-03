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
@Table(name = "map_item")
public class MapItem {
    @Id @Column(name = "id") private Long id;
    @Column(name = "object_id") private Long objectId;

    @Column(name = "map_key") private String key;
    @Column(name = "map_value") private String value;
}
