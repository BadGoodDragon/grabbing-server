package org.grabbing.serverpart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface MapItemDto {
    public String getFirst();
    public String getSecond();

    public void setFirst(String first);
    public void setSecond(String second);
}
