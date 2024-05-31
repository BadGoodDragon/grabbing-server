package org.grabbing.serverpart.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "query_host")
public class Host {
    @Id @Column(name = "id") private Long id;

    @Column(name = "host_name") private String name;

    @Column(name = "sampling_frequency") private Long samplingFrequency;
    @Column(name = "last_take") private Instant lastTake;
}
