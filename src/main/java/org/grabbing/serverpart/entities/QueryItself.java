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
    @Id @Column(name = "id") private Long id;

    @Column(name = "url") private String url;
    @Column(name = "host_id") private Long hostId;

    @Column(name = "parameters_id") private Long parametersMapStartId;
    @Column(name = "headers_id") private Long headersMapStartId;
    @Column(name = "body") private String body;

    @Column(name = "is_has_response") private Boolean isHasResponse;
    @Column(name = "response_id") private Long responseId;

    @Column(name = "face_id") private Long faceId;

    @Column(name = "enabled") private Boolean enabled;
}
    /*@Column(name = "parameters")
    private Map<String, String> parameters;
    @Column(name = "headers")
    private Map<String, String> headers;*/
