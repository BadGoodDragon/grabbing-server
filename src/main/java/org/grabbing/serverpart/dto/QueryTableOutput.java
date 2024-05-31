package org.grabbing.serverpart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface QueryTableOutput {
    public int getId();
    public String getUrl();
    public long getParametersId();
    public long getQueryHeadersId();
    public String getQueryBody();

    public void setId(int id);
    public void setUrl(String url);
    public void setParametersId(long parametersId);
    public void setQueryHeadersId(long queryHeadersId);
    public void setQueryBody(String queryBody);
}
