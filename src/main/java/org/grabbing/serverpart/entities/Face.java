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
@Table(name = "face")
public class Face {
    @Id @Column(name = "id") private Long id;
    @Column(name = "face_name") private String name;
}
