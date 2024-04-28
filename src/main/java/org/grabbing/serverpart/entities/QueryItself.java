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
@Table(name = "query_itself")
public class QueryItself {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "url")
    String url;
    @Column(name = "host_id")
    Long hostId;
    @Column(name = "parameters")
    Map<String, String> parameters;
    @Column(name = "headers")
    Map<String, String> headers;
    @Column(name = "body")
    String body;
    @Column(name = "is_has_response")
    Boolean isHasResponse;
    @Column(name = "response_id")
    Long responseId;
    @Column(name = "face_id")
    Long faceId;
}
