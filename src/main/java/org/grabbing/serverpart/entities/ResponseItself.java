package org.grabbing.serverpart.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "response_itself")
public class ResponseItself {
    @Id @Column(name = "id") private Long id;

    @Column(name = "error") private Boolean error;
    @Column(name = "status_code") private Integer statusCode;

    @Column(name = "headers_id") private Long headersMapStartId;
    @Column(name = "body") private String body;

    @Column(name = "enabled") private Boolean enabled;
}
    /*@Column(name = "headers")
    private Map<String, String> headers;*/
