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
public class ResponseInput {
    private long id;
    private int statusCode;
    private Map<String, String> responseHeaders;
    private String responseBody;
    private boolean error;
}
