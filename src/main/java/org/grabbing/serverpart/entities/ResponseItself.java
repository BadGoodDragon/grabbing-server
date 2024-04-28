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
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "error")
    Boolean error;
    @Column(name = "status_code")
    Integer statusCode;
    @Column(name = "headers")
    Map<String, String> headers;
    @Column(name = "body")
    String body;
}
