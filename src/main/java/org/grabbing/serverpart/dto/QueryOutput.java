package org.grabbing.serverpart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QueryOutput {
    private int id;
    private String url;
    private Map<String, String> parameters;
    private Map<String, String> queryHeaders;
    private String queryBody;
}
